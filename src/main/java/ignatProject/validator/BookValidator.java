package ignatProject.validator;


import ignatProject.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

    @Component
    public class BookValidator implements Validator {

        @Override
        public boolean supports(Class<?> aClass) {
            return Book.class.equals(aClass);
        }

        @Override
        public void validate(Object o, Errors errors) {
            Book book = (Book) o;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","error.not_empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.not_empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.not_empty");



            if (book.getName().length() <= 1) {
                errors.rejectValue("name", "book.error.name.less_2");
            }
            if (book.getName().length() > 32) {
                errors.rejectValue("name", "book.error.name.over_32");
            }
            if (book.getPrice().signum() != 1) {
                errors.rejectValue("price", "book.error.price");

            }
        }
    }

