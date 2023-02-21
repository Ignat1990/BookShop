package service.lmpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static by.bookshop.bookshop.model.Order.Status.sent;


@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    OrderServiceImpl orderService;
    final
    BasketServiceImpl basketService;
    final
    UserServiceImpl userServiceimpl;
    final
    BookServiceImpl bookService;
    final
    BasketRepository basketRepository;
    final
    BookRepository bookRepository;
    final
    UserRepository userRepository;
    final
    OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, OrderRepository orderRepository, BookRepository bookRepository, BasketRepository basketRepository, UserServiceImpl userServiceimpl, BookServiceImpl bookService, BasketServiceImpl basketService) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
        this.userServiceimpl = userServiceimpl;
        this.bookService = bookService;
        this.basketService = basketService;
    }

    @Override
    public Order saveOrder(Order order) {
        log.info("save order" + order);
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return  orderRepository.getOne(id);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        log.info("delete order");
    }

    @Override
    public Order updateOrder(Order order) {
        log.info("update order" + order);
        return orderRepository.save(order);
    }

    @Override
    public List<String> sent(Order order) {
        User newUser = userServiceimpl.findUser(order);
        newUser.setBalance(newUser.getBalance() - bookService.findBook(order).getPrice());
        List<String> list = new ArrayList<>();
        String user = userServiceimpl.findUser(order).toString();
        String  book = bookService.findBook(order).toString();
        list.add(user);
        list.add(book);
        order.setStatus(sent);
        orderRepository.save(order);
        Basket basket = basketService.getBasket(order.getIdBasket());
        basketService.deleteBasket(basket.getId());
        return list;
    }


}
