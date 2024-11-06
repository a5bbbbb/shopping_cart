# Documentation

## Overview

This project simulates an e-commerce shopping cart system using various design patterns to implement common features such as item management, cart handling, and payment processing. The system follows the Model-View-Controller (MVC) architecture with an extensive use of design patterns including Factory, Decorator, Adapter, Observer, and Strategy patterns.

## Packages

### `architecture`

Contains the main MVC components: `CartController`, `ItemController`, and `View`.

- **CartController**: Manages cart-related actions such as creating a cart, adding/removing items, and handling exceptions.
- **ItemController**: Manages item-related actions, including creating items through the Factory pattern.
- **View**: Responsible for displaying information to the user, such as items in the cart and error messages.

### `model`

Contains models for managing carts and items, including interfaces with repositories.

- **CartModel**: Manages cart data and interactions with the cart repository.
- **ItemModel**: Manages item data and interactions with the item repository.

### `patterns.behavioral`

Implements behavioral patterns used within the application.

- **Cart**: Represents a shopping cart containing items and observers.
- **CartObserver**: Abstract class for observers monitoring cart changes.
  - **EmailNotification** and **SMSNotification**: Concrete observers that notify users of cart changes.
- **PaymentStrategy**: Interface for payment strategies, with implementations:
  - **CreditCardPayment** and **PayPalPayment**: Concrete classes implementing payment methods.

### `patterns.creational`

Implements creational patterns for creating item instances.

- **Item**: Abstract class representing items in the cart, with subclasses:
  - **Book** and **Electronics**: Concrete item types with fixed prices.
- **ItemFactory**: Factory class for creating specific item types based on a string identifier.

### `patterns.structural`

Implements structural patterns to modify and enhance item functionality.

- **ItemDecorator**: Abstract decorator class for adding extra features to items.
  - **GiftWrapDecorator**: Concrete decorator for adding gift-wrapping with custom messages and styles.
- **PriceAdapter**: Adapter class for converting item prices into different currencies.

### `repository`

Contains interfaces and implementations for item and cart repositories.

- **CartRepositoryInterface** and **CartRepository**: Interfaces and classes for managing cart data.
- **ItemRepositoryInterface** and **ItemRepository**: Interfaces and classes for managing item data.

### `Main`

Entry point of the application, demonstrating the usage of various patterns and functionalities.

---

## Class Summaries

### `CartController`

- **createShoppingCart()**: Creates a new shopping cart.
- **addItemToShoppingCart(int itemIds, int cartId)**: Adds an item to a specified cart by item and cart IDs.
- **removeItemFromShoppingCart(int itemIds, int cartId)**: Removes an item from a specified cart by item and cart IDs.

### `ItemController`

- **createItem(String itemType)**: Creates a new item of the specified type using `ItemFactory`.

### `View`

- **displayItemsInCart(int cartId)**: Displays all items in a specified cart.
- **displayException(Exception e)**: Prints an exception message.

### `CartModel` and `ItemModel`

- **CartModel**: Manages cart interactions with `CartRepository`.
  - **getCartById(int id)**: Retrieves a cart by ID.
  - **createShoppingCart()**: Creates a new cart.
- **ItemModel**: Manages item interactions with `ItemRepository`.
  - **getItemById(int id)**: Retrieves an item by ID.
  - **getNewId()**: Generates a new item ID.
  - **addNewItem(Item item)**: Adds a new item to the repository.

### `Cart` (patterns.behavioral)

- **addItem(Item item)**: Adds an item to the cart.
- **removeItem(Item item)**: Removes an item from the cart.
- **addObserver(CartObserver obs)**: Adds an observer to the cart.
- **removeObserver(CartObserver obs)**: Removes an observer from the cart.
- **notifyObservers()**: Notifies all observers of changes in the cart.

### `CartObserver` (Abstract) and Subclasses

- **CartObserver**: Abstract observer class with `update()` method for observing cart changes.
  - **EmailNotification** and **SMSNotification**: Concrete observers that send notifications to users.

### `PaymentStrategy` (Interface) and Implementations

- **pay(double amount)**: Method to process payments.
  - **CreditCardPayment** and **PayPalPayment**: Implementations for payment processing strategies.

### `Item` (Abstract) and Subclasses

- **Item**: Abstract class for items, with `getPrice()` method.
  - **Book** and **Electronics**: Concrete item types with fixed prices.

### `ItemFactory`

- **createItem(String type, int id)**: Creates items based on the specified type (e.g., "book" or "electronics").

### `GiftWrapDecorator` and `ItemDecorator`

- **ItemDecorator**: Abstract decorator class that adds features to `Item`.
- **GiftWrapDecorator**: Concrete decorator for adding gift-wrapping options, message, and wrapping style.

### `PriceAdapter`

- **getPriceInCurrency(String currency)**: Converts the item's price to a specified currency.
- **displayConvertedPrice(String currency)**: Prints the converted price in a specified currency.

### `CartRepository` and `ItemRepository`

- **CartRepository**: Manages a list of carts and provides methods for cart retrieval and creation.
- **ItemRepository**: Manages a list of items and provides methods for item retrieval and ID generation.

---

## Execution (Main Class)

- **MVC Initialization**: Initializes `CartController`, `ItemController`, and `View` instances.
- **Factory Pattern**: Demonstrates item creation using `ItemFactory`.
- **Decorator Pattern**: Adds gift-wrapping customization to an item.
- **Adapter Pattern**: Converts and displays item prices in multiple currencies.
- **Observer Pattern**: Adds observers to a cart and notifies them of changes.
- **Strategy Pattern**: Demonstrates payment processing with different strategies.

## UML 
![image](https://github.com/user-attachments/assets/d9d0875e-4f9e-40d3-a154-51c2ab67433e)

