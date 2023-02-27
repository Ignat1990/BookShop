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

import java.util.ArrayList;
import java.util.List;




@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersServiceImpl orderService;
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

    public OrdersServiceImpl(UsersRepository usersRepository, OrdersRepository ordersRepository, BookRepository bookRepository, BasketRepository basketRepository, UsersServiceImpl userServicelmpl, BookServiceImpl bookService, BasketServiceImpl basketService) {
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

    }

    @Override
    public Orders updateOrder(Orders order) {
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
        orders.setDataOrder();
        orderRepository.save(orders);
        Basket basket = basketService.getBasketRepository().getById(orders.getId());
        basketService.delete(basket.getOrders().getId());
        return list;
    }


}
