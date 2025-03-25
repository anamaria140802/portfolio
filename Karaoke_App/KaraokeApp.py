# -*- coding: utf-8 -*-
"""
Created on Thu Nov 28 15:28:24 2024

@author: Ana
"""

import pygame
from tkinter import Tk, Button, filedialog, Label, Text, Scrollbar, Frame
import threading
import time

class MP3PlayerWithLyrics:
    def __init__(self, root):
        self.root = root
        self.root.title("MP3 Player with Lyrics")
        self.audio_file = None
        self.lyrics = {}
        self.is_playing = False
        self.is_loaded = False

        # Configurare pygame mixer
        pygame.mixer.init()

        # Interfață grafică
        self.label = Label(root, text="No file loaded", font=("Helvetica", 14), fg="blue")
        self.label.pack(pady=20)

        control_frame = Frame(root)
        control_frame.pack(pady=10)

        load_button = Button(control_frame, text="Load MP3 + LRC", command=self.load_files, width=15)
        load_button.grid(row=0, column=0, padx=5)

        play_button = Button(control_frame, text="Play", command=self.play_mp3, width=15)
        play_button.grid(row=0, column=1, padx=5)

        stop_button = Button(control_frame, text="Stop", command=self.stop_mp3, width=15)
        stop_button.grid(row=0, column=2, padx=5)

        # Zonă pentru afișarea versurilor
        self.lyrics_text = Text(root, height=15, width=50, wrap="word", state="disabled", font=("Helvetica", 12))
        self.lyrics_text.pack(pady=10)

        scrollbar = Scrollbar(root, command=self.lyrics_text.yview)
        scrollbar.pack(side="right", fill="y")
        self.lyrics_text.config(yscrollcommand=scrollbar.set)

    def load_files(self):
        """Selectează și încarcă un fișier MP3 și fișierul LRC asociat."""
        self.audio_file = filedialog.askopenfilename(filetypes=[("MP3 Files", "*.mp3")])
        if self.audio_file:
            # Încarcă fișierul MP3
            pygame.mixer.music.load(self.audio_file)
            self.label.config(text=f"Loaded: {self.audio_file.split('/')[-1]}")
            self.is_loaded = True

            # Caută fișierul LRC corespunzător
            lrc_file = filedialog.askopenfilename(filetypes=[("LRC Files", "*.lrc")])
            if lrc_file:
                self.load_lyrics(lrc_file)
            else:
                self.lyrics = {}
                self.lyrics_text.config(state="normal")
                self.lyrics_text.delete(1.0, "end")
                self.lyrics_text.insert("end", "No lyrics file loaded")
                self.lyrics_text.config(state="disabled")
        else:
            self.label.config(text="No file loaded")
            self.is_loaded = False

    def load_lyrics(self, lrc_file):
        """Încarcă versurile din fișierul LRC."""
        self.lyrics = {}
        try:
            with open(lrc_file, "r", encoding="utf-8") as f:
                for line in f:
                    if line.startswith("["):
                        timestamp, text = self.parse_lrc_line(line)
                        if timestamp is not None:
                            self.lyrics[timestamp] = text

            self.lyrics_text.config(state="normal")
            self.lyrics_text.delete(1.0, "end")
            for time_key in sorted(self.lyrics.keys()):
                self.lyrics_text.insert("end", f"{self.lyrics[time_key]}\n")
            self.lyrics_text.config(state="disabled")
        except Exception as e:
            self.label.config(text="Error loading lyrics")
            print("Error loading LRC file:", e)

    def parse_lrc_line(self, line):
        """Parsează o linie din fișierul LRC și extrage timestamp-ul și textul."""
        try:
            parts = line.strip().split("]")
            if len(parts) > 1:
                timestamp = parts[0].replace("[", "").split(":")
                minutes = int(timestamp[0])
                seconds = float(timestamp[1])
                time_in_seconds = minutes * 60 + seconds
                text = "]".join(parts[1:]).strip()
                return time_in_seconds, text
        except Exception as e:
            print("Error parsing line:", line, e)
        return None, None

    def play_mp3(self):
        """Redă fișierul MP3 și sincronizează versurile."""
        if self.audio_file and self.is_loaded:
            pygame.mixer.music.play()
            self.is_playing = True
            self.label.config(text=f"Playing: {self.audio_file.split('/')[-1]}")
            threading.Thread(target=self.sync_lyrics, daemon=True).start()
        else:
            self.label.config(text="No MP3 or LRC loaded")

    def stop_mp3(self):
        """Oprește redarea MP3."""
        if self.is_playing:
            pygame.mixer.music.stop()
            self.is_playing = False
            self.label.config(text="Stopped")
        else:
            self.label.config(text="No MP3 is playing")

    def sync_lyrics(self):
        """Sincronizează afișarea versurilor cu redarea audio."""
        if not self.lyrics:
            return

        start_time = time.time()
        while self.is_playing:
            current_time = time.time() - start_time
            for timestamp in sorted(self.lyrics.keys()):
                if current_time >= timestamp:
                    self.update_lyrics_display(self.lyrics[timestamp])
                    del self.lyrics[timestamp]
                    break
            time.sleep(0.1)

    def update_lyrics_display(self, current_line):
        """Actualizează afișarea versurilor în Text widget."""
        self.lyrics_text.config(state="normal")
        self.lyrics_text.delete(1.0, "end")
        self.lyrics_text.insert("end", current_line)
        self.lyrics_text.config(state="disabled")


# Inițializare aplicație
root = Tk()
app = MP3PlayerWithLyrics(root)
root.mainloop()
