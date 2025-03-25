import tkinter as tk
from tkinter import ttk, filedialog
import pygame
import threading
import time
import re
import os

class KaraokeApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Karaoke App")
        self.root.geometry("800x600")
        self.root.configure(bg="#1e1e2e")

        # Initializare pygame mixer
        pygame.mixer.init()

        # Variabile
        self.audio_files = []
        self.lyrics_files = {}
        self.current_index = 0
        self.lyrics = []
        self.is_playing = False
        self.current_line = 0

        # Elemente UI
        self.create_widgets()

        # Eveniment pentru închiderea aplicației
        self.root.protocol("WM_DELETE_WINDOW", self.on_closing)

    def create_widgets(self):
        # Titlu aplicație
        title_label = tk.Label(
            self.root, 
            text="Karaoke Player", 
            font=("Helvetica", 30, "bold"), 
            fg="#f8f8f2", 
            bg="#1e1e2e"
        )
        title_label.pack(pady=20)

        # Panou pentru lista de melodii
        list_frame = tk.Frame(self.root, bg="#1e1e2e")
        list_frame.pack(pady=10)

        # Listbox pentru afișarea melodiilor
        self.song_list = tk.Listbox(
            list_frame, 
            bg="#282a36", 
            fg="#f8f8f2", 
            width=60, 
            height=5, 
            selectbackground="#50fa7b"
        )
        self.song_list.pack()

        self.song_list.bind("<Double-1>", self.on_song_selected)

        # Spațiu între listă și butoane
        space_label = tk.Label(self.root, text="", bg="#1e1e2e", height=2)
        space_label.pack()

        # Panou pentru butoane de control
        control_frame = tk.Frame(self.root, bg="#1e1e2e")
        control_frame.pack(pady=10)

        # Butoane de control cu un aspect mai estetic
        self.load_folder_button = ttk.Button(control_frame, text="Încarcă Folder", command=self.load_folder)
        self.load_folder_button.grid(row=0, column=0, padx=5)

        self.prev_button = ttk.Button(control_frame, text="Precedent", command=self.prev_audio)
        self.prev_button.grid(row=0, column=1, padx=5)

        self.play_button = ttk.Button(control_frame, text="Play", command=self.play_audio)
        self.play_button.grid(row=0, column=2, padx=5)

        self.pause_button = ttk.Button(control_frame, text="Pauză", command=self.pause_audio)
        self.pause_button.grid(row=0, column=3, padx=5)

        self.stop_button = ttk.Button(control_frame, text="Stop", command=self.stop_audio)
        self.stop_button.grid(row=0, column=4, padx=5)

        self.next_button = ttk.Button(control_frame, text="Următor", command=self.next_audio)
        self.next_button.grid(row=0, column=5, padx=5)

        # Bară de progres cu posibilitatea de a muta
        self.progress = ttk.Scale(self.root, from_=0, to=100, orient="horizontal", command=self.seek_audio, length=700)
        self.progress.pack(pady=10)

        # Etichetă pentru afișarea versurilor
        self.lyrics_label = tk.Label(
            self.root, 
            text="", 
            font=("Helvetica", 20), 
            wraplength=700, 
            justify="center", 
            fg="#f8f8f2", 
            bg="#1e1e2e"
        )
        self.lyrics_label.pack(pady=30)

        # Status bar
        self.status_label = tk.Label(
            self.root, 
            text="", 
            font=("Helvetica", 12), 
            fg="#6272a4", 
            bg="#1e1e2e"
        )
        self.status_label.pack(pady=10)

    def load_folder(self):
        folder_path = filedialog.askdirectory()
        if folder_path:
            self.audio_files = [
                os.path.join(folder_path, f) for f in os.listdir(folder_path) 
                if f.lower().endswith(('.mp3', '.wav'))
            ]

            self.lyrics_files = {
                os.path.splitext(f)[0]: os.path.join(folder_path, f) for f in os.listdir(folder_path) 
                if f.lower().endswith('.lrc')
            }

            if self.audio_files:
                self.song_list.delete(0, tk.END)
                for audio_file in self.audio_files:
                    audio_name = os.path.splitext(os.path.basename(audio_file))[0]
                    self.song_list.insert(tk.END, audio_name)

                self.current_index = 0
                self.load_audio()

    def on_song_selected(self, event):
        selection = self.song_list.curselection()
        if selection:
            song_name = self.song_list.get(selection[0])
            for i, audio_file in enumerate(self.audio_files):
                if os.path.splitext(os.path.basename(audio_file))[0] == song_name:
                    self.current_index = i
                    self.load_audio()
                    self.play_audio()
                    break

    def load_audio(self):
        if self.audio_files:
            self.audio_file = self.audio_files[self.current_index]
            audio_name = os.path.splitext(os.path.basename(self.audio_file))[0]
            lyrics_file = self.lyrics_files.get(audio_name)

            if lyrics_file:
                self.parse_lrc(lyrics_file)
                self.status_label.config(text=f"{os.path.basename(self.audio_file)} încărcat!", fg="#50fa7b")
                self.lyrics_label.config(text="Pregătit pentru redare!")
                self.current_line = 0
            else:
                self.lyrics = []
                self.lyrics_label.config(text="Versuri indisponibile pentru această melodie.")

    def parse_lrc(self, filepath):
        self.lyrics = []
        with open(filepath, "r", encoding="utf-8") as file:
            for line in file:
                match = re.match(r"\[(\d+):(\d+\.\d+)\](.+)", line)
                if match:
                    minutes = int(match.group(1))
                    seconds = float(match.group(2))
                    timestamp = minutes * 60 + seconds
                    text = match.group(3)
                    self.lyrics.append((timestamp, text))
        self.lyrics.sort(key=lambda x: x[0])

    def play_audio(self):
        if self.audio_files:
            pygame.mixer.music.load(self.audio_file)
            pygame.mixer.music.play()
            self.is_playing = True
            self.status_label.config(text="Redare...", fg="#50fa7b")
            self.progress.config(to=pygame.mixer.Sound(self.audio_file).get_length())
            threading.Thread(target=self.sync_lyrics).start()
            threading.Thread(target=self.update_progress).start()

    def pause_audio(self):
        if self.is_playing:
            pygame.mixer.music.pause()
            self.is_playing = False
            self.status_label.config(text="Pauză", fg="#ffb86c")

    def stop_audio(self):
        pygame.mixer.music.stop()
        self.is_playing = False
        self.lyrics_label.config(text="")
        self.progress.set(0)
        self.status_label.config(text="Redare oprită", fg="#ff5555")

    def next_audio(self):
        if self.audio_files and self.current_index < len(self.audio_files) - 1:
            self.current_index += 1
            self.load_audio()
            self.play_audio()

    def prev_audio(self):
        if self.audio_files and self.current_index > 0:
            self.current_index -= 1
            self.load_audio()
            self.play_audio()

    def sync_lyrics(self):
        start_time = time.time()
        while self.is_playing and self.current_line < len(self.lyrics):
            current_time = time.time() - start_time
            if self.current_line < len(self.lyrics) and current_time >= self.lyrics[self.current_line][0]:
                self.lyrics_label.config(text=self.lyrics[self.current_line][1])
                self.current_line += 1
            time.sleep(0.1)

    def update_progress(self):
        while self.is_playing:
            self.progress.set(pygame.mixer.music.get_pos() / 1000)
            time.sleep(0.5)

    def seek_audio(self, value):
        if self.is_playing:
            pygame.mixer.music.set_pos(float(value))
            self.status_label.config(text="Redare la " + str(int(float(value))) + " secunde", fg="#f8f8f2")

    def on_closing(self):
        self.stop_audio()
        self.root.destroy()

# Inițializare aplicație
if __name__ == "__main__":
    root = tk.Tk()
    style = ttk.Style()
    style.theme_use("clam")
    app = KaraokeApp(root)
    root.mainloop()
