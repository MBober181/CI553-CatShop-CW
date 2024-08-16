package clients;

import clients.backDoor.BackDoorController;
import clients.backDoor.BackDoorModel;
import clients.backDoor.BackDoorView;
import clients.cashier.*;
import clients.collection.CollectController;
import clients.collection.CollectModel;
import clients.collection.CollectView;
import clients.customer.CustomerController;
import clients.customer.CustomerModel;
import clients.customer.CustomerView;
import clients.shopDisplay.DisplayController;
import clients.shopDisplay.DisplayModel;
import clients.shopDisplay.DisplayView;
import clients.warehousePick.PickController;
import clients.warehousePick.PickModel;
import clients.warehousePick.PickView;
import debug.DEBUG;
import middle.LocalMiddleFactory;
import middle.MiddleFactory;

import javax.swing.*;
import java.awt.*;

class Main {
  private final static boolean many = false;

  public static void main(String[] args) {
    new Main().begin();
  }

  public void begin() {
    MiddleFactory mlf = new LocalMiddleFactory();

    SwingUtilities.invokeLater(() -> {
      startCustomerGUI_MVC(mlf);
      if (many) startCustomerGUI_MVC(mlf);
      startCashierGUI_MVC(mlf);
      startCashierGUI_MVC(mlf);
      startBackDoorGUI_MVC(mlf);
      if (many) startPickGUI_MVC(mlf);
      startPickGUI_MVC(mlf);
      startDisplayGUI_MVC(mlf);
      if (many) startDisplayGUI_MVC(mlf);
      startCollectionGUI_MVC(mlf);
    });
  }

  public void startCustomerGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("Customer Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    CustomerModel model = new CustomerModel(mlf);
    CustomerView view = new CustomerView(window, mlf, pos.width, pos.height);
    CustomerController controller = new CustomerController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
  }

  public void startCashierGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("Cashier Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    BetterCashierModel model = new BetterCashierModel(mlf);
    BetterCashierView view = new BetterCashierView(window, mlf, pos.width, pos.height);
    BetterCashierController controller = new BetterCashierController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
    model.askForUpdate();
  }

  public void startBackDoorGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("BackDoor Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    BackDoorModel model = new BackDoorModel(mlf);
    BackDoorView view = new BackDoorView(window, mlf, pos.width, pos.height);
    BackDoorController controller = new BackDoorController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
  }

  public void startPickGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("Pick Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    PickModel model = new PickModel(mlf);
    PickView view = new PickView(window, mlf, pos.width, pos.height);
    PickController controller = new PickController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
  }

  public void startDisplayGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("Display Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    DisplayModel model = new DisplayModel(mlf);
    DisplayView view = new DisplayView(window, mlf, pos.width, pos.height);
    DisplayController controller = new DisplayController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
  }

  public void startCollectionGUI_MVC(MiddleFactory mlf) {
    JFrame window = new JFrame();
    window.setTitle("Collect Client MVC");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension pos = PosOnScrn.getPos();

    CollectModel model = new CollectModel(mlf);
    CollectView view = new CollectView(window, mlf, pos.width, pos.height);
    CollectController controller = new CollectController(model, view);
    view.setController(controller);

    model.addObserver(view);
    window.setVisible(true);
  }
}

