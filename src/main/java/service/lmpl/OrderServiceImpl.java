package service.lmpl;

import bean.Basket;
import bean.Orders;
import bean.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BasketRepository;
import repository.BookRepository;
import repository.OrdersRepository;
import repository.UsersRepository;
import service.OrdersService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Container.log;


@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    OrderServiceImpl orderService;
    final
    BasketServiceImpl basketService;
    final
    UsersServiceImpl usersServicelmpl;
    final
    BookServiceImpl bookService;
    final
    BasketRepository basketRepository;
    final
    BookRepository bookRepository;
    final
    UsersRepository usersRepository;
    final
    OrdersRepository orderRepository;

    public OrderServiceImpl(UsersRepository usersRepository, OrdersRepository ordersRepository, BookRepository bookRepository, BasketRepository basketRepository, UsersServiceImpl userServicelmpl, BookServiceImpl bookService, BasketServiceImpl basketService, UserDetailsServiceImpl userDetailsService) {
        this.usersRepository = usersRepository;
        this.orderRepository = ordersRepository;
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
        this.usersServicelmpl = userServicelmpl;
        this.bookService = bookService;
        this.basketService = basketService;
    }

    @Override
    public Orders saveOrder(Orders order) {
        log.info("save order" + order);
        return orderRepository.save(order);
    }

    @Override
    public Orders findById(Long id) {
        return  orderRepository.getOne(id);
    }

    @Override
    public List<Orders> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        log.info("delete order");
    }

    @Override
    public Orders updateOrder(Orders order) {
        log.info("update order" + order);
        return orderRepository.save(order);
    }

    @Override
    public List<String> sent(Orders orders) {
        Users newUser = usersServicelmpl.findUser(orders);
        newUser.setBalance(newUser.getBalance() - bookService.findBook(orders).getPrice());
        List<String> list = new ArrayList<>();
        String user = usersServicelmpl.findUser(orders).toString();
        String  book = bookService.findBook(orders).toString();
        list.add(user);
        list.add(book);
        orders.setDataOrder(sent);
        orderRepository.save(orders);
        Basket basket = basketService.getBasket(orders.getBasket();
        basketService.deleteBasket(basket.getBook().getId());
        return list;
    }


}
