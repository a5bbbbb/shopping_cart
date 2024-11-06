# **Shopping Cart Project Documentation**

## **Overview**

The shopping cart application simulates a simple e-commerce system in Java using various design patterns to demonstrate software architectural principles. This documentation covers the project’s architecture, design patterns, UML structure, and usage instructions.

### **Architecture**

The project is designed using the **Model-View-Controller (MVC)** architecture pattern to separate the data model (Model), user interface (View), and business logic (Controller). This separation allows for easier testing, maintainability, and flexibility.

1. **Model**: Holds the data (e.g., total price of items).
2. **View**: Displays data to the user.
3. **Controller**: Handles interactions and updates the Model and View.

### **Implemented Design Patterns**

The project employs multiple design patterns, categorized into creational, structural, and behavioral patterns, enhancing modularity, reusability, and scalability.

## **Design Patterns**

### **1. Creational Patterns**

#### **Singleton Pattern**: `CartSingleton`

- **Purpose**: Ensures there is only one instance of the shopping cart throughout the application.
- **Usage**: The `CartSingleton` class controls access to a single cart instance, which maintains the total price of items added to it.
  
  ```java
  CartSingleton cart = CartSingleton.getInstance();
  cart.addToTotal(100); // Adds $100 to the cart
  ```

#### **Factory Pattern**: `ItemFactory`

- **Purpose**: Allows for the creation of different item types without exposing the instantiation logic.
- **Usage**: The `ItemFactory` class creates item objects (e.g., `Book`, `Electronics`) based on the specified type, which is useful for dynamically adding different item types to the cart.

  ```java
  Item book = ItemFactory.createItem("book");
  Item electronics = ItemFactory.createItem("electronics");
  ```

### **2. Structural Patterns**

#### **Adapter Pattern**: `PriceAdapter` and `MultiCurrencyAdapter`

- **Purpose**: Converts the price of items into different currencies, adapting the interface of item prices for internationalization.
- **Usage**: The `MultiCurrencyAdapter` converts the price in USD to other currencies like Euros or GBP.

  ```java
  MultiCurrencyAdapter adapter = new MultiCurrencyAdapter(book);
  double priceInEuros = adapter.getPriceInCurrency("euro");
  ```

#### **Decorator Pattern**: `ItemDecorator` and `GiftWrapDecorator`

- **Purpose**: Adds additional functionality (e.g., gift wrapping) to items without altering their structure.
- **Usage**: `GiftWrapDecorator` decorates an item by adding an additional cost for gift wrapping.

  ```java
  Item giftWrappedBook = new GiftWrapDecorator(book);
  ```

### **3. Behavioral Patterns**

#### **Observer Pattern**: `CartObserver`, `EmailNotification`, and `SMSNotification`

- **Purpose**: Notifies observers whenever the total price of the cart is updated, useful for sending updates to the user.
- **Usage**: `CartObserver` is implemented by `EmailNotification` and `SMSNotification` classes to receive notifications of cart updates.

  ```java
  Cart cart = new Cart();
  cart.addObserver(new EmailNotification());
  cart.addObserver(new SMSNotification());
  cart.addToTotal(50); // Triggers notifications
  ```

#### **Strategy Pattern**: `PaymentStrategy`, `CreditCardPayment`, `PayPalPayment`, and `DiscountStrategy`

- **Purpose**: Provides multiple payment strategies and discount options that can be dynamically chosen at runtime.
- **Usage**: `CreditCardPayment` and `PayPalPayment` implement the `PaymentStrategy` interface, while `DiscountStrategy` adds various discount methods.

  ```java
  PaymentStrategy payment = new CreditCardPayment();
  DiscountStrategy discount = new PercentageDiscount(10); // 10% discount
  payment.pay(cart.getTotal(), discount);
  ```

## **Usage Instructions**

1. **Initialize the MVC components** to separate the logic, view, and model.

   ```java
   Model model = new Model();
   View view = new View();
   Controller cartController = new Controller(model, view);
   ```

2. **Create items** using the `ItemFactory`.

   ```java
   Item book = ItemFactory.createItem("book");
   ```

3. **Add items to the cart** and manage the cart instance using `CartSingleton`.

   ```java
   CartSingleton cart = CartSingleton.getInstance();
   cart.addToTotal(book.getPrice());
   ```

4. **Convert prices to different currencies** if needed.

   ```java
   MultiCurrencyAdapter adapter = new MultiCurrencyAdapter(book);
   double priceInGBP = adapter.getPriceInCurrency("gbp");
   ```

5. **Add gift wrapping** or other decoration to items using `ItemDecorator`.

   ```java
   Item giftWrappedBook = new GiftWrapDecorator(book);
   ```

6. **Set up notifications** for the cart using `CartObserver`.

   ```java
   Cart cart = new Cart();
   cart.addObserver(new EmailNotification());
   ```

7. **Choose a payment strategy and apply discounts** if applicable.

   ```java
   PaymentStrategy payment = new CreditCardPayment();
   DiscountStrategy discount = new PercentageDiscount(15); // 15% discount
   payment.pay(cart.getTotal(), discount);
   ```

## **Assumptions and Limitations**

- **Assumptions**:
  - Only two item types (`Book` and `Electronics`) are defined, but more can be added.
  - The system assumes users can use only one currency conversion at a time.
  - Discount is applied at the time of payment, not during item addition.

- **Limitations**:
  - Multi-currency support is limited to USD, Euro, and GBP.
  - The notification system doesn’t differentiate between email and SMS messages; all notifications are triggered on every update.

## **Future Enhancements**

1. **Additional Item Types**: Expand the `ItemFactory` to create more types of items.
2. **Enhanced Currency Conversion**: Integrate real-time exchange rates for better currency conversions.
3. **User-Specific Notifications**: Customize notifications based on user preferences.
4. **More Discount Types**: Add more complex discounting logic, like tiered discounts or membership-based discounts.
5. **Enhanced Payment Methods**: Include additional payment strategies (e.g., cryptocurrency or mobile payments).

## **UML Diagram**

The UML diagram provides an overview of the system structure and how different classes interact. Each pattern and relationship is illustrated to show inheritance, composition, and dependency relationships among the classes.

![Screenshot 2024-11-05 153304](https://github.com/user-attachments/assets/00621479-0b19-46db-a177-69ddf9cfc85d)
