package ignatProject.controllers;


import ignatProject.model.Book;
import ignatProject.repository.BasketRepository;
import ignatProject.repository.BookRepository;
import ignatProject.repository.OrderRepository;
import ignatProject.repository.UserRepository;
import ignatProject.service.impl.OrderServiceImpl;
import ignatProject.service.impl.ShoppingCartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    protected ShoppingCartServiceImpl shoppingCartServiceImpl;
    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected BasketRepository orderProductMapRepository;

    @Autowired
    protected OrderServiceImpl orderServiceImpl;

    @Autowired
    protected UserRepository userRepository;


    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("book", shoppingCartServiceImpl.booksInCart());
        model.addAttribute("totalPrice", shoppingCartServiceImpl.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addBookToCart(@PathVariable("id") long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            shoppingCartServiceImpl.addBook(book);
            logger.debug(String.format("Book with id: %s added to shopping cart.", id));
        }
        return "redirect:/index";
    }

    @GetMapping("/cartfrombookganre/add/{id}")
    public String addProdToCart(@PathVariable("id") long id) {
        Book book = bookRepository.findById(id).get();
        if (book != null) {
            shoppingCartServiceImpl.addBook(book);
            logger.debug(String.format("Book with id: %s added to shopping cart.", id));
        }
        String red = "redirect:/searchByBookGanre/" + book.getBookGange().getId();
        System.out.println(red);
        return red;
    }

    @GetMapping("/cart/remove/{id}")
    public String removeBookFromCart(@PathVariable("id") long id) {
        Book book = bookRepository.findById(id).get();

        if (book != null) {
            shoppingCartServiceImpl.removeBook(book);
            logger.debug(String.format("Book with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearBooksInCart() {
        shoppingCartServiceImpl.clearBooks();

        return "redirect:/cart";
    }

}


