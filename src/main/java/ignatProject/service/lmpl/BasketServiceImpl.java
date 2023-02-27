package ignatProject.service.lmpl;

import ignatProject.bean.Basket;
import ignatProject.service.BasketService;
import org.springframework.stereotype.Service;
import ignatProject.repository.BasketRepository;
import ignatProject.repository.BookRepository;

import java.util.List;

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
    public void deleteBasket(Long id) {

    }

    @Override
    public Basket addBookInBasket(Basket basket) {
        return null;
    }

    @Override
    public Basket getBasket(Long id) {
        return null;
    }


    public List<Basket> findAll() {
        return null;
    }


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


    public Basket save(Basket basket) {
        return basketRepository.save(basket);

    }


    public Basket find(Long id) {
        return basketRepository.getOne(id);
    }

}
