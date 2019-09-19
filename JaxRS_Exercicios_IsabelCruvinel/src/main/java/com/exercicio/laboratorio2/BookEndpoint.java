package com.exercicio.laboratorio2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.laboratorio1.entidades.Book;
import com.exercicio.laboratorio1.jersey.book.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("v1")
public class BookEndpoint {

    @Autowired
    private BookService bookService;

    @ApiOperation(value="Retorna uma lista com todos os livros.", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou a lista de Usuários"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path="books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @ApiOperation(value="Retorna um livro", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou o Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path="book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ApiOperation(value="Cria um livro", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criou o Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path="book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value="Atualiza um livro", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou o Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path="book/{id}")
    public ResponseEntity<?> updateBook (@PathVariable("id") int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="Excui um livro", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Excluiu o Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path="book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
