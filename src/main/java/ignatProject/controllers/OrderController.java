package ignatProject.controllers;


import ignatProject.model.Basket;
import ignatProject.model.Book;
import ignatProject.model.Order;
import ignatProject.model.User;
import ignatProject.enumm.Status;
import ignatProject.repository.BasketRepository;
import ignatProject.repository.BookRepository;
import ignatProject.repository.OrderRepository;
import ignatProject.service.impl.OrderServiceImpl;
import ignatProject.service.impl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Map;

import static ignatProject.enumm.Status.ACCEPTED;


@RequestMapping("/user")
@Controller
public class OrderController {

    @Autowired
    protected ShoppingCartServiceImpl shoppingCartServiceImpl;

    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected BasketRepository basketRepository;

    @Autowired
    protected OrderServiceImpl orderServiceImpl;

    @GetMapping("/carttoorder")
    public String carttoorder() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<Book, Integer> mapcart = shoppingCartServiceImpl.getCart();
        System.out.println("MAPA=" + mapcart);
        Order newOrder = new Order();
        Status newStatus = ACCEPTED;
        newOrder.setStatus(newStatus.toString());
        newOrder.setUser(user);
        newOrder.setGrand_total(shoppingCartServiceImpl.totalPrice());
        newOrder.setDateoforder(LocalDate.now());
        newOrder.setDescription("My order");
        System.out.println("NEWORDER=" + newOrder);
        orderServiceImpl.saveOrder(newOrder);
        System.out.println("OrderAfterSave=" + newOrder);

        for (Map.Entry<Book, Integer> entry : mapcart.entrySet()) {
            Basket basket = new Basket();
            System.out.println("ID =  " + entry.getKey() + " Значение = " + entry.getValue());
            basket.setOrder(newOrder);
            basket.setOrderid(newOrder.getId());
            basket.setBook(entry.getKey());
            basket.setQuantity(entry.getValue());
            basket.setPrice(entry.getKey().getPrice());
            basketRepository.save(basket);
        }
        shoppingCartServiceImpl.clearBooks();
        return "redirect:/index";
    }


    @GetMapping("/orders")
    public String userList(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("MYORDER" + user + orderRepository.findById(user.getId()));
        model.addAttribute("OrdersUser", orderRepository.findByUser(user));

        return "order/ordersuser";
    }

    @GetMapping("/orders/view/{id}")
    public String userid(@PathVariable("id") Long id, Model model) {
        Order order = orderServiceImpl.findOrder(id).get();
        System.out.println("Order=" + order);
        model.addAttribute("OrdersBooks", basketRepository.findAllByOrderId(order.getId()));

        return "order/order";
    }

    @GetMapping("/delete/order/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        orderServiceImpl.deleteOrder(id);
        return "redirect:/user/order";
    }


}


