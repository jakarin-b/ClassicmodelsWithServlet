package sit.int202.classicmodelweb;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.CustomerRepository;
import sit.int202.classicmodelweb.repositories.ProductRepository;

public class Main {
    public static void main(String[] args) {
//        ProductRepository productRepository = new ProductRepository();
//        System.out.println(productRepository.findAll(1,5));
//        System.out.println("Total items: "+ productRepository.countAll());

        String password = "1234";
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName("Jean King");
        System.out.println(customer);
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
        System.out.println(result.toString());
        System.out.println(result.validFormat);
        System.out.println(result.verified);

//        Cart<String, ClassicModelLineItem> cart = new Cart<>();
//        ProductRepository productRepository = new ProductRepository();
//        Product product = productRepository.findProduct("S10_1678");
//        cart.addItem(product.getId(), new ClassicModelLineItem(product,5));
//        product = productRepository.findProduct("S12_3380");
//        cart.addItem(product.getId(), new ClassicModelLineItem(product));
//        System.out.println(cart.countItem());
//        System.out.println(cart.countPiece());
//        System.out.println(cart.getTotalPrice());
//        System.out.println(cart.getAllItem());
//        cart.removeItem("S10_1678");

//        OfficeRepository officeRepository = new OfficeRepository();
//        Office office = officeRepository.find("1");
//        office.setCity("Vientiane");
//        officeRepository.update(office);
//        officeRepository.delete("10");


//        Office newOffice = new Office();
//        newOffice.setId("8");
//        newOffice.setCity("Bangkok");
//        newOffice.setCountry("TH");
//        newOffice.setAddressLine1(office.getAddressLine1());
//        newOffice.setAddressLine2(office.getAddressLine2());
//        newOffice.setPhone(office.getPhone());
//        newOffice.setPostalCode(office.getPostalCode());
//        newOffice.setTerritory(office.getTerritory());
//        officeRepository.save(newOffice);
//
//        for(Office o : officeRepository.findAll()) {
//            System.out.println(o.getId() + ": " + o.getCity());
//            System.out.println("----------------------------------------------------------------------------------------------");
//            office.getEmployeeList().forEach(employee -> {
//                printEmp(employee);
//            });
//            System.out.println("\n");
//        }
////        EmployeeRepository employeeRepository = new EmployeeRepository();
////        Employee employee = employeeRepository.find(1056);
////
////        System.out.println(office);
////        System.out.println(employee);
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        System.out.println("-------------------------------------");
//        employeeRepository.findByDescreption("pa").forEach(employee -> {
//            printEmp(employee);
//        });

//    }
//    private static void printEmp(Employee e) {
//        System.out.printf("%7d %-10s %-15s %-20s %s\n", e.getId(), e.getFirstName(),
//                e.getLastName(), e.getJobTitle(), e.getEmail());
//
    }
}
