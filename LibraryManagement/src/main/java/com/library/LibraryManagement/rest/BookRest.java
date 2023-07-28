package com.library.LibraryManagement.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibraryManagement.entities.Book;
import com.library.LibraryManagement.repositories.BookDao;


@RestController
public class BookRest {
	
	@Autowired
	private BookDao bdao;
	
	@GetMapping(value = "/Books")
    public ResponseEntity<java.util.List<Book>> getBooks() {
        List<Book> books = bdao.findAll();
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id){
		Optional<Book> opt = bdao.findById(id);
		if ((!opt.isPresent())){
			return ResponseEntity.noContent().build();
		}else
			return ResponseEntity.ok(opt.get());
	}
	
	@PostMapping("/add_book")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book newbook = bdao.save(book);
		return ResponseEntity.ok(newbook);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Book>> deleteBook(@PathVariable Long id){
		bdao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update_book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		Optional<Book> opt = bdao.findById(book.getId());
		if (!opt.isPresent()){
			return ResponseEntity.noContent().build();
		}
		Book updbook = opt.get();
		updbook.setName(book.getName());
		updbook.setAuthor(book.getAuthor());
		updbook.setPages(book.getPages());
		updbook.setPrice(book.getPrice());
		bdao.save(updbook);
		return ResponseEntity.ok(updbook);
		
	}
}

