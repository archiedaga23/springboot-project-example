package com.demo.note.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.note.model.Note;
import com.demo.note.repository.NoteRepository;

@RestController
@CrossOrigin
@RequestMapping("/note")
public class NoteContoller {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping
	public List<Note> getNotes() {
		return noteRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Note> getNoteById(@PathVariable Long id) {
		Optional<Note> n = noteRepository.findById(id);
		return n;
	}
	
	@PostMapping
	public Note addNote(@RequestBody Note newNote) {
		return noteRepository.saveAndFlush(new Note(newNote.getValue()));
	}
	
	@DeleteMapping("{id}")
	public Long deleteNote(@PathVariable Long id) {
		noteRepository.deleteById(id);
		return id;
	}
	
	@PatchMapping
	public Note updateNote(@RequestBody Note note) {
		return noteRepository.save(note);
	}

}
