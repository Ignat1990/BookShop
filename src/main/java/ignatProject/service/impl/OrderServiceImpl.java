package ignatProject.service.impl;


import ignatProject.model.Order;
import ignatProject.repository.OrderRepository;
import ignatProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    protected OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    public Optional<Order> findOrder(Long id) {
        return orderRepository.findById(id);
    }


}

/*    final
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
    OrdersRepository ordersRepository;

    public OrdersServiceImpl(UsersRepository usersRepository, OrdersRepository ordersRepository, BookRepository bookRepository, BasketRepository basketRepository, UsersServiceImpl userServicelmpl, BookServiceImpl bookService, BasketServiceImpl basketService) {
        this.usersRepository = usersRepository;
        this.ordersRepository = ordersRepository;
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
        this.usersServicelmpl = userServicelmpl;
        this.bookService = bookService;
        this.basketService = basketService;
    }


    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }


    public Orders findById(Long id) {
        return  ordersRepository.getOne(id);
    }


    public List<Orders> findAllOrder() {
        return ordersRepository.findAll();
    }


    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);

    }


    public Orders updateOrder(Orders order) {
        return ordersRepository.save(order);
    }




    public List<String> sent(Orders orders) {
        Users newUser = usersServicelmpl.findUser(orders);
        newUser.setBalance(newUser.getBalance() - bookService.findBook(orders).getPrice());
        List<String> list = new ArrayList<>();
        String user = usersServicelmpl.findUser(orders).toString();
        String  book = bookService.findBook(orders).toString();
        list.add(user);
        list.add(book);
        orders.setDataOrder();
        ordersRepository.save(orders);
        Basket basket = basketService.getBasketRepository().getById(orders.getId());
        basketService.delete(basket.getOrders().getId());
        return list;
    }*/



