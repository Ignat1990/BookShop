package service.lmpl;

import bean.Basket;
import org.springframework.stereotype.Service;
import repository.BasketRepository;
import repository.BookRepository;
import service.BasketService;

import java.awt.*;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.MESSAGE_ALL;
import static org.aspectj.bridge.MessageUtil.info;

@Service
public class BasketServiceImpl implements BasketService {

    final
    BookRepository bookRepository;
    final
    BasketRepository basketRepository;

    public BasketServiceImpl(BookRepository bookRepository, BasketRepository basketRepository) {
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
    }


    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }

    @Override
    public List<Basket> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {
        Basket basket =   basketRepository.getOne(id);
        basketRepository.delete(basket);

    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);

    }

    @Override
    public Basket find(Long id) {
        return basketRepository.getOne(id);
    }

}
