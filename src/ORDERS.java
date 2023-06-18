
import java.sql.Connection;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/*    JTextField = new JTextField();
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jhonl
 */
public class ORDERS extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form orders
     */
    private FOR_UPDATE updateModal;

    public ORDERS() {
        initComponents();

        updateModal = new FOR_UPDATE();

        cheese();
        pepperoniprice();
        chickenhawaiin();
        veggies();
        superchocolate();
        oreocookies();
        brownsugar();
        milkystrawberry();
        darkchoco();
        darkcaramel();
        oreochoco();
        saltedcaramel();
        oreooverlaod();
        nutellaspecial();
        wintermelon();
        chocoberry();
        ygreenapple();
        ystrawberry();
        ypassion();
        lychee();
        lemon();
        blueberry();
        oreo();
        nutellahazel();
        redvelvet();
        chocoloco();
        oreonutella();
        nutellavelvet();
        choconutella();
        nutellaberry();
        fgreenapple();
        fstrawberry();
        fpassion();
        flychee();
        flemon();
        fblueberry();
        sinkers();
        topp();
        add();

    }

    DefaultTableModel model;
    String product_name;
    String size;
    int qty;
    double price;
    double totalprice;

    PreparedStatement pst1;

    public void cal() {
        //CALL TOTAL TABLE VALUES
        int numOfRow = ORDERS_TABLE.getRowCount();
        double tot = 0.0;
        for (int i = 0; i < numOfRow; i++) {
            double value = Double.valueOf(ORDERS_TABLE.getValueAt(i, 3).toString());
            tot += value;
        }
        DecimalFormat df = new DecimalFormat("00.00");
        txttotal.setText(df.format(tot));
    }

    private void txt() {
        int sum = 0;

        for (int a = 0; a < ORDERS_TABLE.getRowCount(); a++) {
            double totalprice = Double.parseDouble(ORDERS_TABLE.getValueAt(a, 4).toString());
            sum += totalprice;
        }

        txttotal.setText(Integer.toString(sum));
    }

//    public void pay() {
//
//        double price1 = Double.parseDouble(txttotal.getText());
//        int pay1 = Integer.parseInt(txtpay.getText());
//
//        if (pay1 < price1) {
//            JOptionPane.showMessageDialog(this, "Insufficient payment. Please enter the correct amount.");
//        } else {
//            double bal = pay1 - price1;
//            txtbal.setText(String.valueOf(bal));
//
//            if (pay1 >= price1) {
//                // Save to database code here
//                save_purchase();
//
//                // Generate and print the receipt
//                // ...
//            } else {
//                JOptionPane.showMessageDialog(this, "Insufficient payment. Cannot save to the database.");
//            }
//        }
//
//    }
    private void sizes() {

        try {

            // Execute a database query to retrieve the items
            String selectedSize0 = (String) cheese_s.getSelectedItem();
            String query0 = "SELECT size FROM pizza_cheese";
            pst = conn.prepareStatement(query0);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size = rs.getString("size");

                cheese_s.addItem(size);
                ;
            }

            String query1 = "SELECT size FROM pizza_pepperoni";
            pst = conn.prepareStatement(query1);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size1 = rs.getString("size");
                pepperoni_s.addItem(size1);

            }

            String query2 = "SELECT size FROM pizza_chicken_hawaiin";
            pst = conn.prepareStatement(query2);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size2 = rs.getString("size");
                chicken_s.addItem(size2);

            }
            String query3 = "SELECT size FROM pizza_veggies";
            pst = conn.prepareStatement(query3);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size3 = rs.getString("size");
                veggies_s.addItem(size3);

            }

            String query4 = "SELECT size FROM premium_super_chocolate";
            pst = conn.prepareStatement(query4);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size4 = rs.getString("size");
                super_s.addItem(size4);

            }
            String query5 = "SELECT size FROM premium_oreo_cookies_cream";
            pst = conn.prepareStatement(query5);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size5 = rs.getString("size");
                occ_s.addItem(size5);

            }
            String query6 = "SELECT size FROM premium_brown_sugar_ukinawa";
            pst = conn.prepareStatement(query6);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size6 = rs.getString("size");
                bsu_s.addItem(size6);

            }
            String query7 = "SELECT size FROM premium_milky_strawberry";
            pst = conn.prepareStatement(query7);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size7 = rs.getString("size");
                ms_s.addItem(size7);

            }
            String query8 = "SELECT size FROM premium_dark_choco";
            pst = conn.prepareStatement(query8);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size8 = rs.getString("size");
                dc_s.addItem(size8);

            }
            String query9 = "SELECT size FROM premium_dark_choco_caramel";
            pst = conn.prepareStatement(query9);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size9 = rs.getString("size");
                dcc_s.addItem(size9);

            }

            String query10 = "SELECT size FROM premium_oreo_choco";
            pst = conn.prepareStatement(query10);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size10 = rs.getString("size");
                oc_s.addItem(size10);

            }

            String query11 = "SELECT size FROM premium_salted_caramel";
            pst = conn.prepareStatement(query11);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size11 = rs.getString("size");
                scaramel_s.addItem(size11);

            }
            String query12 = "SELECT size FROM house_special_oreo_overload ";
            pst = conn.prepareStatement(query12);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size12 = rs.getString("size");
                oo_s.addItem(size12);

            }
            String query13 = "SELECT size FROM house_special_nutella_special ";
            pst = conn.prepareStatement(query13);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size13 = rs.getString("size");
                ns_s.addItem(size13);

            }
            String query14 = "SELECT size FROM house_special_wintermelon_milk ";
            pst = conn.prepareStatement(query14);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size14 = rs.getString("size");
                wm_s.addItem(size14);

            }
            String query15 = "SELECT size FROM house_special_chocoberry ";
            pst = conn.prepareStatement(query15);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size15 = rs.getString("size");
                cb_s.addItem(size15);

            }
            String query16 = "SELECT size FROM yogurt_green_apple";
            pst = conn.prepareStatement(query16);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size16 = rs.getString("size");
                ga1_s.addItem(size16);

            }
            String query17 = "SELECT size FROM yogurt_strawberry";
            pst = conn.prepareStatement(query17);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size17 = rs.getString("size");
                s1_s.addItem(size17);

            }
            String query18 = "SELECT size FROM yogurt_passion_fruit";
            pst = conn.prepareStatement(query18);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size18 = rs.getString("size");
                ps1_s.addItem(size18);

            }
            String query19 = "SELECT size FROM yogurt_lychee";
            pst = conn.prepareStatement(query19);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size19 = rs.getString("size");
                l1_s.addItem(size19);

            }
            String query20 = "SELECT size FROM yogurt_lemon";
            pst = conn.prepareStatement(query20);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size20 = rs.getString("size");
                ln1_s.addItem(size20);

            }
            String query21 = "SELECT size FROM yogurt_blueberry";
            pst = conn.prepareStatement(query21);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size21 = rs.getString("size");
                b1_s.addItem(size21);

            }
            String query22 = "SELECT size FROM cheesecake_oreo";
            pst = conn.prepareStatement(query22);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size22 = rs.getString("size");
                o_s.addItem(size22);

            }
            String query23 = "SELECT size FROM cheesecake_nutella_hazelnut";
            pst = conn.prepareStatement(query23);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size23 = rs.getString("size");
                nh_s.addItem(size23);

            }

            String query24 = "SELECT size FROM cheesecake_red_velvet";
            pst = conn.prepareStatement(query24);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size24 = rs.getString("size");
                rv_s.addItem(size24);

            }
            String query25 = "SELECT size FROM cheesecake_chocoloco";
            pst = conn.prepareStatement(query25);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size25 = rs.getString("size");
                clo_s.addItem(size25);

            }
            String query26 = "SELECT size FROM nutella_oreo_nutella";
            pst = conn.prepareStatement(query26);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size26 = rs.getString("size");
                on_s.addItem(size26);

            }
            String query27 = "SELECT size FROM nutella_nutella_velvet";
            pst = conn.prepareStatement(query27);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size27 = rs.getString("size");
                nv_s.addItem(size27);

            }
            String query28 = "SELECT size FROM nutella_choco_nutella";
            pst = conn.prepareStatement(query28);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size28 = rs.getString("size");
                cn_s.addItem(size28);

            }
            String query29 = "SELECT size FROM nutella_nutella_berry";
            pst = conn.prepareStatement(query29);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size29 = rs.getString("size");
                nb_s.addItem(size29);

            }
            String query30 = "SELECT size FROM fruit_tea_green_apple";
            pst = conn.prepareStatement(query30);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size30 = rs.getString("size");
                ga2_s.addItem(size30);

            }
            String query31 = "SELECT size FROM fruit_tea_strawberry";
            pst = conn.prepareStatement(query31);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size31 = rs.getString("size");
                s2_s.addItem(size31);

            }
            String query32 = "SELECT size FROM fruit_tea_passion_fruit";
            pst = conn.prepareStatement(query32);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size32 = rs.getString("size");
                p2_s.addItem(size32);

            }
            String query33 = "SELECT size FROM fruit_tea_lychee";
            pst = conn.prepareStatement(query33);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size33 = rs.getString("size");
                l2_s.addItem(size33);

            }
            String query34 = "SELECT size FROM fruit_tea_lemon";
            pst = conn.prepareStatement(query34);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size34 = rs.getString("size");
                ln2_s.addItem(size34);

            }
            String query35 = "SELECT size FROM fruit_tea_blueberry";
            pst = conn.prepareStatement(query35);
            rs = pst.executeQuery();

            while (rs.next()) {
                String size35 = rs.getString("size");
                b2_s.addItem(size35);

            }
            String query36 = "SELECT prodname FROM add_sinkers";
            pst = conn.prepareStatement(query36);
            rs = pst.executeQuery();

            while (rs.next()) {
                String product_name = rs.getString("prodname");
                sinker_i.addItem(product_name);

            }
            String query37 = "SELECT prodname FROM  add_topp";
            pst = conn.prepareStatement(query37);
            rs = pst.executeQuery();

            while (rs.next()) {
                String product_name1 = rs.getString("prodname");
                topp_i.addItem(product_name1);

            }
            String query38 = "SELECT prodname FROM  add_add";
            pst = conn.prepareStatement(query38);
            rs = pst.executeQuery();

            while (rs.next()) {
                String product_name2 = rs.getString("prodname");
                add_i.addItem(product_name2);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void bill() {

        Date currentDate = new Date();

        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        // Format the time
        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String formattedTime = timeFormat.format(currentDate);

        try {
            // Establish database connection
            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderingsystem", "root", "");

            // Prepare the query to retrieve the sales ID
            String query = "SELECT sales_id FROM purchase WHERE id "; // Replace with your actual query

            // Execute the query
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Retrieve the sales ID
            int salesId = 0;
            if (resultSet.next()) {
                salesId = resultSet.getInt("sales_id");
            }

            // Close the database connection and resources
            resultSet.close();
            statement.close();
            connection.close();

            String billText = String.format("%-40s%n", "Tea-Cup Time");
            billText += String.format("%-40s%n", "Polomolok South Cotabato");
            billText += String.format("%-40s%n", "6/78");
            billText += String.format("%-40s%n", "Philippines");
            billText += String.format("%-40s%n", "09097562760");
            billText += "-------------------------------------------------------\n";
            billText += "-------------------------------------------------------\n";
            billText += String.format("%-14s: %s%n", "Date", formattedDate);
            billText += String.format("%-14s: %s%n", "Ordered Time", formattedTime);
            billText += "-------------------------------------------------------\n";
            billText += String.format("%-14s: %s%n", "Sales ID", salesId);
            billText += "-------------------------------------------------------\n";
            billText += String.format("%-14s: %s%n", "Date", formattedDate);
            billText += String.format("%-14s: %s%n", "Ordered Time", formattedTime);
            billText += "Product name\tSize\tPrice\tQty\n";

            DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();

            for (int i = 0; i < ORDERS_TABLE.getRowCount(); i++) {
                String productName = (String) ORDERS_TABLE.getValueAt(i, 0);
                String size = (String) ORDERS_TABLE.getValueAt(i, 1);
                Double price = (Double) ORDERS_TABLE.getValueAt(i, 2);
                int quantity = (int) ORDERS_TABLE.getValueAt(i, 3);

                String formattedPrice = String.format("%.2f", price);
                String formattedQuantity = String.valueOf(quantity);

                billText += String.format("%-14s\t%-14s\t%-14s\t%-14s%n", productName, size, formattedPrice, formattedQuantity);
            }

            billText += "\n\n\n";
            billText += "-------------------------------------------------------\n";
            billText += String.format("%-14s: %s%n", "Sub Total", txttotal.getText());
            billText += String.format("%-14s: %s%n", "Cash", txtpay.getText());
            billText += String.format("%-14s: %s%n", "Balance", txtbal.getText());
            billText += "-------------------------------------------------------\n";
            billText += "Thanks For Your Business...!!!\n";
            billText += "-------------------------------------------------------\n";
            billText += "Come Again\n";

// Add the scroll pane to your desired container or frame
// For example, if your frame is called "frame":
            txtbill.setText(billText);
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

// Method to retrieve the updated product name based on the size
    private String getProductBySize(String size) {
        // Implement your logic here to determine the updated product name based on the size
        // Return the updated product name
        return "Updated Product Name";
    }

    public void save_purchase() {
        double price1 = Double.parseDouble(txttotal.getText());
        int pay1 = Integer.parseInt(txtpay.getText());

        if (pay1 < price1) {
            JOptionPane.showMessageDialog(this, "Insufficient payment. Please enter the correct amount.");
        } else {

            int lastid = 0;

            double bal = pay1 - price1;
            txtbal.setText(String.valueOf(bal));

            if (pay1 >= price1) {
                try {

                    double subtotal = Double.parseDouble(txttotal.getText());
                    double balance = Double.parseDouble(txtbal.getText());
                    double pay = Double.parseDouble(txtpay.getText());

                    String query = "INSERT INTO sales (subtotal,balance,payment)VALUES (?,?,?)";

                    pst = (PreparedStatement) conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    pst.setDouble(1, subtotal);
                    pst.setDouble(2, balance);
                    pst.setDouble(3, pay);
                    pst.executeUpdate();
                    rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        lastid = rs.getInt(1);
                    }

                    String query1 = "INSERT INTO purchase(sales_id, product_name, size, price, qty) VALUES (?, ?, ?, ?, ?)";
                    pst1 = (PreparedStatement) conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);

                    String product_name = "";
                    String size;
                    double price;
                    int qty;

                    for (int i = 0; i < ORDERS_TABLE.getRowCount(); i++) {
                        product_name = (String) ORDERS_TABLE.getValueAt(i, 0);
                        size = (String) ORDERS_TABLE.getValueAt(i, 1);
                        price = (Double) ORDERS_TABLE.getValueAt(i, 2);
                        qty = (int) ORDERS_TABLE.getValueAt(i, 3);

                        pst1.setInt(1, lastid);
                        pst1.setString(2, product_name);
                        pst1.setString(3, size);
                        pst1.setDouble(4, price);
                        pst1.setInt(5, qty);

                        pst1.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(null, "Sale completed");

                } catch (SQLException e) {
                    Logger.getLogger(ORDERS.class.getName()).log(Level.SEVERE, null, e);

                }
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient payment. Cannot save to the database.");
            }
        }

    }

    /* public void delete() {
     try {
     String sqll = "DELETE FROM sales WHERE id = '" + textfield.getText() + "'";
     pst = conn.prepareStatement(sqll);
     pst.execute();
     try {
     String sql2 = "DELETE FROM student_report WHERE studentr_name= '" + name_textfield.getText() + "'";
     pst = conn.prepareStatement(sql2);
     pst.execute();
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, e);
     }}catch(Exception e){}

     }*/
    private void cheese() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize0 = (String) cheese_s.getSelectedItem();

            String sql0 = "SELECT * FROM pizza_cheese WHERE size = ?";
            pst = conn.prepareStatement(sql0);
            pst.setString(1, selectedSize0);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price0 = rs.getDouble("price");
                cheese_p.setText(String.valueOf((price0)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void pepperoniprice() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize1 = (String) pepperoni_s.getSelectedItem();

            String sql1 = "SELECT * FROM pizza_pepperoni WHERE size = ?";
            pst = conn.prepareStatement(sql1);
            pst.setString(1, selectedSize1);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price1 = rs.getDouble("price");
                pepperoni_p.setText(String.valueOf(price1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void chickenhawaiin() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize2 = (String) chicken_s.getSelectedItem();

            String sql2 = "SELECT * FROM pizza_chicken_hawaiin WHERE size = ?";
            pst = conn.prepareStatement(sql2);
            pst.setString(1, selectedSize2);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price2 = rs.getDouble("price");
                chicken_p.setText(String.valueOf(price2));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void veggies() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize3 = (String) veggies_s.getSelectedItem();

            String sql3 = "SELECT * FROM pizza_veggies WHERE size = ?";
            pst = conn.prepareStatement(sql3);
            pst.setString(1, selectedSize3);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price3 = rs.getDouble("price");
                veggies_p.setText(String.valueOf(price3));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void superchocolate() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize4 = (String) super_s.getSelectedItem();

            String sql4 = "SELECT * FROM premium_super_chocolate WHERE size = ?";
            pst = conn.prepareStatement(sql4);
            pst.setString(1, selectedSize4);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price4 = rs.getDouble("price");
                super_p.setText(String.valueOf(price4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void oreocookies() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize5 = (String) occ_s.getSelectedItem();

            String sql5 = "SELECT * FROM premium_oreo_cookies_cream WHERE size = ?";
            pst = conn.prepareStatement(sql5);
            pst.setString(1, selectedSize5);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price5 = rs.getDouble("price");
                occ_p.setText(String.valueOf(price5));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void brownsugar() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize6 = (String) bsu_s.getSelectedItem();

            String sql6 = "SELECT * FROM premium_brown_sugar_ukinawa WHERE size = ?";
            pst = conn.prepareStatement(sql6);
            pst.setString(1, selectedSize6);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price6 = rs.getDouble("price");
                bsu_p.setText(String.valueOf(price6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void milkystrawberry() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize8 = (String) ms_s.getSelectedItem();

            String sql8 = "SELECT * FROM premium_milky_strawberry WHERE size = ?";
            pst = conn.prepareStatement(sql8);
            pst.setString(1, selectedSize8);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price8 = rs.getDouble("price");
                ms_p.setText(String.valueOf(price8));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void darkchoco() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize9 = (String) dc_s.getSelectedItem();

            String sql9 = "SELECT * FROM premium_dark_choco WHERE size = ?";
            pst = conn.prepareStatement(sql9);
            pst.setString(1, selectedSize9);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price9 = rs.getDouble("price");
                dc_p.setText(String.valueOf(price9));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void darkcaramel() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize10 = (String) dcc_s.getSelectedItem();

            String sql10 = "SELECT * FROM premium_dark_choco_caramel WHERE size = ?";
            pst = conn.prepareStatement(sql10);
            pst.setString(1, selectedSize10);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price10 = rs.getDouble("price");
                dcc_p.setText(String.valueOf(price10));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void oreochoco() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize11 = (String) oc_s.getSelectedItem();

            String sql11 = "SELECT * FROM premium_oreo_choco WHERE size = ?";
            pst = conn.prepareStatement(sql11);
            pst.setString(1, selectedSize11);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price11 = rs.getDouble("price");
                oc_p.setText(String.valueOf(price11));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saltedcaramel() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize12 = (String) scaramel_s.getSelectedItem();

            String sql12 = "SELECT * FROM premium_salted_caramel WHERE size = ?";
            pst = conn.prepareStatement(sql12);
            pst.setString(1, selectedSize12);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price12 = rs.getDouble("price");
                sc1_p.setText(String.valueOf(price12));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void oreooverlaod() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize13 = (String) oo_s.getSelectedItem();

            String sql13 = "SELECT * FROM house_special_oreo_overload WHERE size = ?";
            pst = conn.prepareStatement(sql13);
            pst.setString(1, selectedSize13);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price13 = rs.getDouble("price");
                oo_p.setText(String.valueOf(price13));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void nutellaspecial() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize14 = (String) ns_s.getSelectedItem();

            String sql14 = "SELECT * FROM house_special_nutella_special WHERE size = ?";
            pst = conn.prepareStatement(sql14);
            pst.setString(1, selectedSize14);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price14 = rs.getDouble("price");
                ns_p.setText(String.valueOf(price14));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void wintermelon() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize15 = (String) wm_s.getSelectedItem();

            String sql15 = "SELECT * FROM house_special_wintermelon_milk WHERE size = ?";
            pst = conn.prepareStatement(sql15);
            pst.setString(1, selectedSize15);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price15 = rs.getDouble("price");
                wm_p.setText(String.valueOf(price15));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void chocoberry() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize16 = (String) cb_s.getSelectedItem();

            String sql16 = "SELECT * FROM house_special_chocoberry WHERE size = ?";
            pst = conn.prepareStatement(sql16);
            pst.setString(1, selectedSize16);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price16 = rs.getDouble("price");
                c_p.setText(String.valueOf(price16));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ygreenapple() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize17 = (String) ga1_s.getSelectedItem();

            String sql17 = "SELECT * FROM yogurt_green_apple WHERE size = ?";
            pst = conn.prepareStatement(sql17);
            pst.setString(1, selectedSize17);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price17 = rs.getDouble("price");
                ga1_p.setText(String.valueOf(price17));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void ystrawberry() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize18 = (String) s1_s.getSelectedItem();

            String sql18 = "SELECT * FROM yogurt_strawberry WHERE size = ?";
            pst = conn.prepareStatement(sql18);
            pst.setString(1, selectedSize18);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price18 = rs.getDouble("price");
                s1_p.setText(String.valueOf(price18));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ypassion() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize19 = (String) ps1_s.getSelectedItem();

            String sql19 = "SELECT * FROM yogurt_passion_fruit WHERE size = ?";
            pst = conn.prepareStatement(sql19);
            pst.setString(1, selectedSize19);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price19 = rs.getDouble("price");
                pf1_p.setText(String.valueOf(price19));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void lychee() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize20 = (String) l1_s.getSelectedItem();

            String sql20 = "SELECT * FROM yogurt_lychee WHERE size = ?";
            pst = conn.prepareStatement(sql20);
            pst.setString(1, selectedSize20);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price20 = rs.getDouble("price");
                l1_p.setText(String.valueOf(price20));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void lemon() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize21 = (String) ln1_s.getSelectedItem();

            String sql21 = "SELECT * FROM yogurt_lemon WHERE size = ?";
            pst = conn.prepareStatement(sql21);
            pst.setString(1, selectedSize21);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price21 = rs.getDouble("price");
                ln1_p.setText(String.valueOf(price21));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void blueberry() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize22 = (String) b1_s.getSelectedItem();

            String sql22 = "SELECT * FROM yogurt_blueberry WHERE size = ?";
            pst = conn.prepareStatement(sql22);
            pst.setString(1, selectedSize22);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price22 = rs.getDouble("price");
                bb1_p.setText(String.valueOf(price22));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void oreo() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize23 = (String) o_s.getSelectedItem();

            String sql23 = "SELECT * FROM cheesecake_oreo WHERE size = ?";
            pst = conn.prepareStatement(sql23);
            pst.setString(1, selectedSize23);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price23 = rs.getDouble("price");
                o_p.setText(String.valueOf(price23));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void nutellahazel() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize24 = (String) nh_s.getSelectedItem();

            String sql24 = "SELECT * FROM cheesecake_nutella_hazelnut WHERE size = ?";
            pst = conn.prepareStatement(sql24);
            pst.setString(1, selectedSize24);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price23 = rs.getDouble("price");
                nh_p.setText(String.valueOf(price23));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void redvelvet() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize25 = (String) rv_s.getSelectedItem();

            String sql25 = "SELECT * FROM cheesecake_red_velvet WHERE size = ?";
            pst = conn.prepareStatement(sql25);
            pst.setString(1, selectedSize25);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price25 = rs.getDouble("price");
                rv_p.setText(String.valueOf(price25));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void chocoloco() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize26 = (String) clo_s.getSelectedItem();

            String sql26 = "SELECT * FROM cheesecake_chocoloco WHERE size = ?";
            pst = conn.prepareStatement(sql26);
            pst.setString(1, selectedSize26);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price26 = rs.getDouble("price");
                cl_p.setText(String.valueOf(price26));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void oreonutella() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize27 = (String) on_s.getSelectedItem();

            String sql27 = "SELECT * FROM nutella_oreo_nutella WHERE size = ?";
            pst = conn.prepareStatement(sql27);
            pst.setString(1, selectedSize27);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price27 = rs.getDouble("price");
                on_p.setText(String.valueOf(price27));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void nutellavelvet() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize28 = (String) nv_s.getSelectedItem();

            String sql28 = "SELECT * FROM nutella_nutella_velvet WHERE size = ?";
            pst = conn.prepareStatement(sql28);
            pst.setString(1, selectedSize28);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price28 = rs.getDouble("price");
                nv_p.setText(String.valueOf(price28));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void choconutella() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize29 = (String) cn_s.getSelectedItem();

            String sql29 = "SELECT * FROM nutella_choco_nutella WHERE size = ?";
            pst = conn.prepareStatement(sql29);
            pst.setString(1, selectedSize29);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price29 = rs.getDouble("price");
                cn_p.setText(String.valueOf(price29));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void nutellaberry() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize30 = (String) nb_s.getSelectedItem();

            String sql30 = "SELECT * FROM nutella_nutella_berry WHERE size = ?";
            pst = conn.prepareStatement(sql30);
            pst.setString(1, selectedSize30);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price30 = rs.getDouble("price");
                nb_p.setText(String.valueOf(price30));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fgreenapple() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize31 = (String) ga2_s.getSelectedItem();

            String sql31 = "SELECT * FROM fruit_tea_green_apple WHERE size = ?";
            pst = conn.prepareStatement(sql31);
            pst.setString(1, selectedSize31);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price31 = rs.getDouble("price");
                ga_p.setText(String.valueOf(price31));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fstrawberry() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize32 = (String) s2_s.getSelectedItem();

            String sql32 = "SELECT * FROM fruit_tea_strawberry WHERE size = ?";
            pst = conn.prepareStatement(sql32);
            pst.setString(1, selectedSize32);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price32 = rs.getDouble("price");
                s_p.setText(String.valueOf(price32));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fpassion() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize33 = (String) p2_s.getSelectedItem();

            String sql33 = "SELECT * FROM fruit_tea_passion_fruit WHERE size = ?";
            pst = conn.prepareStatement(sql33);
            pst.setString(1, selectedSize33);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price33 = rs.getDouble("price");
                pf_p.setText(String.valueOf(price33));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void flychee() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize34 = (String) l2_s.getSelectedItem();

            String sql34 = "SELECT * FROM fruit_tea_lychee WHERE size = ?";
            pst = conn.prepareStatement(sql34);
            pst.setString(1, selectedSize34);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price34 = rs.getDouble("price");
                l_p.setText(String.valueOf(price34));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void flemon() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize35 = (String) ln2_s.getSelectedItem();

            String sql35 = "SELECT * FROM fruit_tea_lemon WHERE size = ?";
            pst = conn.prepareStatement(sql35);
            pst.setString(1, selectedSize35);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price35 = rs.getDouble("price");
                ln_p.setText(String.valueOf(price35));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fblueberry() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize36 = (String) b2_s.getSelectedItem();

            String sql36 = "SELECT * FROM fruit_tea_blueberry WHERE size = ?";
            pst = conn.prepareStatement(sql36);
            pst.setString(1, selectedSize36);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price36 = rs.getDouble("price");
                b_p.setText(String.valueOf(price36));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void sinkers() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize37 = (String) sinker_i.getSelectedItem();

            String sql37 = "SELECT * FROM add_sinkers WHERE prodname = ?";
            pst = conn.prepareStatement(sql37);
            pst.setString(1, selectedSize37);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price37 = rs.getDouble("price");
                sinkers_p.setText(String.valueOf(price37));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void topp() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize38 = (String) topp_i.getSelectedItem();

            String sql38 = "SELECT * FROM add_topp WHERE prodname = ?";
            pst = conn.prepareStatement(sql38);
            pst.setString(1, selectedSize38);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price38 = rs.getDouble("price");
                topp_p.setText(String.valueOf(price38));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void add() {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/orderingsystem", "root", "");

            String selectedSize39 = (String) add_i.getSelectedItem();

            String sql39 = "SELECT * FROM add_add WHERE prodname = ?";
            pst = conn.prepareStatement(sql39);
            pst.setString(1, selectedSize39);

            rs = pst.executeQuery();

            while (rs.next()) {
                double price39 = rs.getDouble("price");
                add_p.setText(String.valueOf(price39));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pizza_p = new javax.swing.JPanel();
        product_c = new javax.swing.JLabel();
        cheese_s = new javax.swing.JComboBox();
        cheese_a = new javax.swing.JButton();
        cheese_q = new javax.swing.JLabel();
        cheese_m = new javax.swing.JButton();
        c_add = new javax.swing.JButton();
        pepperoni = new javax.swing.JLabel();
        pepperoni_s = new javax.swing.JComboBox();
        pepperoni_a = new javax.swing.JButton();
        pepperoni_q = new javax.swing.JLabel();
        pepperoni_m = new javax.swing.JButton();
        p_add = new javax.swing.JButton();
        chicken_hawaiin = new javax.swing.JLabel();
        chicken_s = new javax.swing.JComboBox();
        chicken_a = new javax.swing.JButton();
        chicken_q = new javax.swing.JLabel();
        ch_add = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        veggies_s = new javax.swing.JComboBox();
        veggies_a = new javax.swing.JButton();
        veggies_q = new javax.swing.JLabel();
        veggies_m = new javax.swing.JButton();
        veggies_add = new javax.swing.JButton();
        chicken_m = new javax.swing.JButton();
        cheese_p = new javax.swing.JLabel();
        pepperoni_p = new javax.swing.JLabel();
        p_t = new javax.swing.JLabel();
        chicken_p = new javax.swing.JLabel();
        veggies_p = new javax.swing.JLabel();
        cheese_t = new javax.swing.JLabel();
        ch_t = new javax.swing.JLabel();
        v_t = new javax.swing.JLabel();
        premium_p = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        super_s = new javax.swing.JComboBox();
        sc_a = new javax.swing.JButton();
        sc_q = new javax.swing.JLabel();
        sc_m = new javax.swing.JButton();
        sc_add = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        occ_s = new javax.swing.JComboBox();
        occ_a = new javax.swing.JButton();
        occ_q = new javax.swing.JLabel();
        occ_m = new javax.swing.JButton();
        occ_add = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        bsu_s = new javax.swing.JComboBox();
        bsu_a = new javax.swing.JButton();
        bsu_q = new javax.swing.JLabel();
        bsu_m = new javax.swing.JButton();
        bsu_add = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        ms_s = new javax.swing.JComboBox();
        ms_q = new javax.swing.JLabel();
        ms_a = new javax.swing.JButton();
        ms_m = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        dc_a = new javax.swing.JButton();
        dc_q = new javax.swing.JLabel();
        dc_m = new javax.swing.JButton();
        dc_s = new javax.swing.JComboBox();
        dc_add = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        dcc_s = new javax.swing.JComboBox();
        dcc_a = new javax.swing.JButton();
        dcc_q = new javax.swing.JLabel();
        dcc_m = new javax.swing.JButton();
        dcc_add = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        oc_s = new javax.swing.JComboBox();
        oc_a = new javax.swing.JButton();
        oc_q = new javax.swing.JLabel();
        oc_m = new javax.swing.JButton();
        oc_add = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        scaramel_s = new javax.swing.JComboBox();
        sc1_a = new javax.swing.JButton();
        sc1_m = new javax.swing.JButton();
        sc1_q = new javax.swing.JLabel();
        sc1_add = new javax.swing.JButton();
        sc_p = new javax.swing.JLabel();
        super_p = new javax.swing.JLabel();
        occ_p = new javax.swing.JLabel();
        bsu_p = new javax.swing.JLabel();
        ms_p = new javax.swing.JLabel();
        dc_p = new javax.swing.JLabel();
        dcc_p = new javax.swing.JLabel();
        oc_p = new javax.swing.JLabel();
        sc1_p = new javax.swing.JLabel();
        super_t = new javax.swing.JLabel();
        occ_t = new javax.swing.JLabel();
        bsu_t = new javax.swing.JLabel();
        ms_t = new javax.swing.JLabel();
        dc_t = new javax.swing.JLabel();
        dcc_t = new javax.swing.JLabel();
        oc_t = new javax.swing.JLabel();
        sc1_t = new javax.swing.JLabel();
        house_p = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        oo_s = new javax.swing.JComboBox();
        oo_a = new javax.swing.JButton();
        oo_q = new javax.swing.JLabel();
        oo_m = new javax.swing.JButton();
        oo_add = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        ns_a = new javax.swing.JButton();
        ns_q = new javax.swing.JLabel();
        ns_m = new javax.swing.JButton();
        ns_add = new javax.swing.JButton();
        ns_s = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        wm_s = new javax.swing.JComboBox();
        wm_a = new javax.swing.JButton();
        wm_q = new javax.swing.JLabel();
        wm_m = new javax.swing.JButton();
        wm_add = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        cb_s = new javax.swing.JComboBox();
        c_a = new javax.swing.JButton();
        c_q = new javax.swing.JLabel();
        c_m = new javax.swing.JButton();
        cb_add = new javax.swing.JButton();
        oo_p = new javax.swing.JLabel();
        ns_p = new javax.swing.JLabel();
        wm_p = new javax.swing.JLabel();
        c_p = new javax.swing.JLabel();
        oo_t = new javax.swing.JLabel();
        ns_t = new javax.swing.JLabel();
        wm_t = new javax.swing.JLabel();
        c_t = new javax.swing.JLabel();
        ga1_t = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        ga1_a = new javax.swing.JButton();
        ga1_s = new javax.swing.JComboBox();
        ga1_q = new javax.swing.JLabel();
        ga1_m = new javax.swing.JButton();
        ga1_add = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        s1_s = new javax.swing.JComboBox();
        s1_a = new javax.swing.JButton();
        s1_q = new javax.swing.JLabel();
        s1_m = new javax.swing.JButton();
        s1_add = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        ps1_s = new javax.swing.JComboBox();
        pf1_a = new javax.swing.JButton();
        pf1_q = new javax.swing.JLabel();
        pf1_m = new javax.swing.JButton();
        pf1_add = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        l1_s = new javax.swing.JComboBox();
        l1_a = new javax.swing.JButton();
        l1_q = new javax.swing.JLabel();
        l1_m = new javax.swing.JButton();
        l1_add = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        ln1_s = new javax.swing.JComboBox();
        ln1_a = new javax.swing.JButton();
        ln1_q = new javax.swing.JLabel();
        ln1_m = new javax.swing.JButton();
        ln1_add = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        b1_s = new javax.swing.JComboBox();
        bb1_a = new javax.swing.JButton();
        b1_q = new javax.swing.JLabel();
        bb1_m = new javax.swing.JButton();
        bb1_add = new javax.swing.JButton();
        ga1_p = new javax.swing.JLabel();
        s1_p = new javax.swing.JLabel();
        pf1_p = new javax.swing.JLabel();
        l1_p = new javax.swing.JLabel();
        ln1_p = new javax.swing.JLabel();
        bb1_p = new javax.swing.JLabel();
        ga_T = new javax.swing.JLabel();
        s1_t = new javax.swing.JLabel();
        pf1_t = new javax.swing.JLabel();
        l1_t = new javax.swing.JLabel();
        ln1_t = new javax.swing.JLabel();
        bb1_t = new javax.swing.JLabel();
        cheesecake_p = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        o_s = new javax.swing.JComboBox();
        o_a = new javax.swing.JButton();
        o_q = new javax.swing.JLabel();
        o_m = new javax.swing.JButton();
        o_add = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        nh_s = new javax.swing.JComboBox();
        nh_a = new javax.swing.JButton();
        nh_q = new javax.swing.JLabel();
        nh_m = new javax.swing.JButton();
        nh_add = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        rv_s = new javax.swing.JComboBox();
        rv_a = new javax.swing.JButton();
        rv_q = new javax.swing.JLabel();
        rv_m = new javax.swing.JButton();
        rv_add = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        clo_s = new javax.swing.JComboBox();
        cl_a = new javax.swing.JButton();
        cl_q = new javax.swing.JLabel();
        cl_m = new javax.swing.JButton();
        cl_add = new javax.swing.JButton();
        o_p = new javax.swing.JLabel();
        nh_p = new javax.swing.JLabel();
        rv_p = new javax.swing.JLabel();
        cl_p = new javax.swing.JLabel();
        o_t = new javax.swing.JLabel();
        nh_t = new javax.swing.JLabel();
        rv_t = new javax.swing.JLabel();
        cl_t = new javax.swing.JLabel();
        nuttela_p = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        on_s = new javax.swing.JComboBox();
        on_a = new javax.swing.JButton();
        on_q = new javax.swing.JLabel();
        on_m = new javax.swing.JButton();
        on_add = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        nv_s = new javax.swing.JComboBox();
        nv_a = new javax.swing.JButton();
        nv_q = new javax.swing.JLabel();
        nv_m = new javax.swing.JButton();
        nv_add = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        cn_s = new javax.swing.JComboBox();
        cn_a = new javax.swing.JButton();
        cn_q = new javax.swing.JLabel();
        cn_m = new javax.swing.JButton();
        cn_add = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        nb_s = new javax.swing.JComboBox();
        nb_a = new javax.swing.JButton();
        nb_q = new javax.swing.JLabel();
        nb_m = new javax.swing.JButton();
        nb_add = new javax.swing.JButton();
        on_p = new javax.swing.JLabel();
        nv_p = new javax.swing.JLabel();
        cn_p = new javax.swing.JLabel();
        nb_p = new javax.swing.JLabel();
        on_t = new javax.swing.JLabel();
        nv_t = new javax.swing.JLabel();
        cn_t = new javax.swing.JLabel();
        nb_t = new javax.swing.JLabel();
        fruit_p = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        ga2_s = new javax.swing.JComboBox();
        ga_a = new javax.swing.JButton();
        ga_q = new javax.swing.JLabel();
        ga_m = new javax.swing.JButton();
        ga_add = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        s_a = new javax.swing.JButton();
        s_q = new javax.swing.JLabel();
        s_m = new javax.swing.JButton();
        s_add = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        p2_s = new javax.swing.JComboBox();
        pf_a = new javax.swing.JButton();
        pf_m = new javax.swing.JButton();
        pf_q = new javax.swing.JLabel();
        pf_add = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        l2_s = new javax.swing.JComboBox();
        l_a = new javax.swing.JButton();
        l_q = new javax.swing.JLabel();
        l_m = new javax.swing.JButton();
        l_add = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        ln2_s = new javax.swing.JComboBox();
        ln_a = new javax.swing.JButton();
        ln_q = new javax.swing.JLabel();
        ln_m = new javax.swing.JButton();
        ln_add = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        b2_s = new javax.swing.JComboBox();
        b_a = new javax.swing.JButton();
        b_q = new javax.swing.JLabel();
        b_m = new javax.swing.JButton();
        b_add = new javax.swing.JButton();
        s2_s = new javax.swing.JComboBox();
        ga_p = new javax.swing.JLabel();
        s_p = new javax.swing.JLabel();
        pf_p = new javax.swing.JLabel();
        l_p = new javax.swing.JLabel();
        ln_p = new javax.swing.JLabel();
        b_p = new javax.swing.JLabel();
        ga_t = new javax.swing.JLabel();
        s_t = new javax.swing.JLabel();
        pf_t = new javax.swing.JLabel();
        l_t = new javax.swing.JLabel();
        ln_t = new javax.swing.JLabel();
        b_t = new javax.swing.JLabel();
        addtional_p = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        sinker_i = new javax.swing.JComboBox();
        sinkers_a = new javax.swing.JButton();
        sinkers_q = new javax.swing.JLabel();
        sinkers_m = new javax.swing.JButton();
        sinkers_add = new javax.swing.JButton();
        sinkers_p = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        sinkers_t = new javax.swing.JLabel();
        topp_i = new javax.swing.JComboBox();
        topp_a = new javax.swing.JButton();
        topp_q = new javax.swing.JLabel();
        topp_m = new javax.swing.JButton();
        topp_t = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        add_i = new javax.swing.JComboBox();
        add_a = new javax.swing.JButton();
        add_q = new javax.swing.JLabel();
        add_m = new javax.swing.JButton();
        add_add = new javax.swing.JButton();
        topp_add = new javax.swing.JButton();
        topp_p = new javax.swing.JLabel();
        add_p = new javax.swing.JLabel();
        add_t = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ORDERS_TABLE = new javax.swing.JTable();
        t = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtbal = new javax.swing.JLabel();
        payment_b = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        UPDATE_TABLE = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pizza_p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pizza_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        product_c.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        product_c.setText("Cheese");
        pizza_p.add(product_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 30));

        cheese_s.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cheese_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cheese  Size" }));
        cheese_s.setToolTipText("");
        cheese_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cheese_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cheese_sMouseClicked(evt);
            }
        });
        cheese_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheese_sActionPerformed(evt);
            }
        });
        pizza_p.add(cheese_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, 30));

        cheese_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cheese_a.setText("+");
        cheese_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cheese_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheese_aActionPerformed(evt);
            }
        });
        pizza_p.add(cheese_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 50, -1));

        cheese_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cheese_q.setText("0");
        pizza_p.add(cheese_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 50, -1));

        cheese_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cheese_m.setText("-");
        cheese_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cheese_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheese_mActionPerformed(evt);
            }
        });
        pizza_p.add(cheese_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 50, -1));

        c_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_add.setText("Add");
        c_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        c_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_addActionPerformed(evt);
            }
        });
        pizza_p.add(c_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 30));

        pepperoni.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        pepperoni.setText("Pepperoni");
        pizza_p.add(pepperoni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 130, -1));

        pepperoni_s.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        pepperoni_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pepperoni Size" }));
        pepperoni_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pepperoni_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepperoni_sActionPerformed(evt);
            }
        });
        pizza_p.add(pepperoni_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 180, 30));

        pepperoni_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pepperoni_a.setText("+");
        pepperoni_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pepperoni_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepperoni_aActionPerformed(evt);
            }
        });
        pizza_p.add(pepperoni_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 50, -1));

        pepperoni_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pepperoni_q.setText("0");
        pizza_p.add(pepperoni_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 30, -1));

        pepperoni_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pepperoni_m.setText("-");
        pepperoni_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pepperoni_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pepperoni_mActionPerformed(evt);
            }
        });
        pizza_p.add(pepperoni_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 50, -1));

        p_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_add.setText("Add");
        p_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        p_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_addActionPerformed(evt);
            }
        });
        pizza_p.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 80, 30));

        chicken_hawaiin.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        chicken_hawaiin.setText("Chicken Hawaiin ");
        pizza_p.add(chicken_hawaiin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        chicken_s.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        chicken_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chicken Hawaiin Size" }));
        chicken_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        chicken_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chicken_sActionPerformed(evt);
            }
        });
        pizza_p.add(chicken_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 190, 30));

        chicken_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chicken_a.setText("+");
        chicken_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        chicken_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chicken_aActionPerformed(evt);
            }
        });
        pizza_p.add(chicken_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 50, -1));

        chicken_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chicken_q.setText("0");
        pizza_p.add(chicken_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 30, 20));

        ch_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ch_add.setText("Add");
        ch_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ch_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_addActionPerformed(evt);
            }
        });
        pizza_p.add(ch_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 80, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel17.setText("Veggies");
        pizza_p.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 110, 40));

        veggies_s.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        veggies_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Veggies Size" }));
        veggies_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        veggies_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veggies_sActionPerformed(evt);
            }
        });
        pizza_p.add(veggies_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 170, 30));

        veggies_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        veggies_a.setText("+");
        veggies_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        veggies_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veggies_aActionPerformed(evt);
            }
        });
        pizza_p.add(veggies_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 50, -1));

        veggies_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        veggies_q.setText("0");
        pizza_p.add(veggies_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 40, 20));

        veggies_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        veggies_m.setText("-");
        veggies_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        veggies_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veggies_mActionPerformed(evt);
            }
        });
        pizza_p.add(veggies_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 50, -1));

        veggies_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        veggies_add.setText("Add");
        veggies_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        veggies_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veggies_addActionPerformed(evt);
            }
        });
        pizza_p.add(veggies_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 80, 30));

        chicken_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chicken_m.setText("-");
        chicken_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        chicken_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chicken_mActionPerformed(evt);
            }
        });
        pizza_p.add(chicken_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 50, -1));
        pizza_p.add(cheese_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 60, 20));
        pizza_p.add(pepperoni_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 40, 30));
        pizza_p.add(p_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 40, 20));
        pizza_p.add(chicken_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 40, 20));
        pizza_p.add(veggies_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 40, 30));
        pizza_p.add(cheese_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 144, 40, 20));
        pizza_p.add(ch_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 40, 30));
        pizza_p.add(v_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 50, 30));

        jTabbedPane1.addTab("Pizza", pizza_p);

        premium_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setText("Super Chocolate");
        premium_p.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, -1));

        super_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        super_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        super_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        super_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                super_sActionPerformed(evt);
            }
        });
        premium_p.add(super_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 30));

        sc_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc_a.setText("+");
        sc_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sc_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc_aActionPerformed(evt);
            }
        });
        premium_p.add(sc_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, -1));

        sc_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sc_q.setText("0");
        premium_p.add(sc_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, -1));

        sc_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc_m.setText("-");
        sc_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sc_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc_mActionPerformed(evt);
            }
        });
        premium_p.add(sc_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        sc_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc_add.setText("Add");
        sc_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        sc_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc_addActionPerformed(evt);
            }
        });
        premium_p.add(sc_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel22.setText("Oreo Cookies & Cream ");
        premium_p.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 20));

        occ_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        occ_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        occ_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        occ_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occ_sActionPerformed(evt);
            }
        });
        premium_p.add(occ_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        occ_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        occ_a.setText("+");
        occ_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        occ_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occ_aActionPerformed(evt);
            }
        });
        premium_p.add(occ_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 60, -1));

        occ_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        occ_q.setText("0");
        premium_p.add(occ_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 30, -1));

        occ_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        occ_m.setText("-");
        occ_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        occ_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occ_mActionPerformed(evt);
            }
        });
        premium_p.add(occ_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 60, -1));

        occ_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        occ_add.setText("Add");
        occ_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        occ_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occ_addActionPerformed(evt);
            }
        });
        premium_p.add(occ_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel24.setText("Brown Sugar Ukinawa");
        premium_p.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 160, -1));

        bsu_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        bsu_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        bsu_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bsu_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsu_sActionPerformed(evt);
            }
        });
        premium_p.add(bsu_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 110, 30));

        bsu_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bsu_a.setText("+");
        bsu_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bsu_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsu_aActionPerformed(evt);
            }
        });
        premium_p.add(bsu_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 60, -1));

        bsu_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bsu_q.setText("0");
        premium_p.add(bsu_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 40, 20));

        bsu_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bsu_m.setText("-");
        bsu_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bsu_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsu_mActionPerformed(evt);
            }
        });
        premium_p.add(bsu_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 60, -1));

        bsu_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bsu_add.setText("Add");
        bsu_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        bsu_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsu_addActionPerformed(evt);
            }
        });
        premium_p.add(bsu_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel26.setText("Milky Strawberry");
        premium_p.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 120, -1));

        ms_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ms_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ms_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ms_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ms_sActionPerformed(evt);
            }
        });
        premium_p.add(ms_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 110, 30));

        ms_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ms_q.setText("0");
        premium_p.add(ms_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 30, -1));

        ms_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ms_a.setText("+");
        ms_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ms_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ms_aActionPerformed(evt);
            }
        });
        premium_p.add(ms_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 60, -1));

        ms_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ms_m.setText("-");
        ms_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ms_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ms_mActionPerformed(evt);
            }
        });
        premium_p.add(ms_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 60, -1));

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setText("Add");
        jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        premium_p.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 90, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel28.setText("Dark Chocolate");
        premium_p.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, -1));

        dc_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dc_a.setText("+");
        dc_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        dc_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_aActionPerformed(evt);
            }
        });
        premium_p.add(dc_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 60, -1));

        dc_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dc_q.setText("0");
        premium_p.add(dc_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 30, -1));

        dc_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dc_m.setText("-");
        dc_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        dc_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_mActionPerformed(evt);
            }
        });
        premium_p.add(dc_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 60, -1));

        dc_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        dc_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        dc_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dc_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_sActionPerformed(evt);
            }
        });
        premium_p.add(dc_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 110, 30));

        dc_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dc_add.setText("Add");
        dc_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        dc_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dc_addActionPerformed(evt);
            }
        });
        premium_p.add(dc_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 90, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel30.setText("Dark Choco Caramel ");
        premium_p.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        dcc_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        dcc_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        dcc_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dcc_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcc_sActionPerformed(evt);
            }
        });
        premium_p.add(dcc_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 110, 30));

        dcc_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcc_a.setText("+");
        dcc_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        dcc_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcc_aActionPerformed(evt);
            }
        });
        premium_p.add(dcc_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 60, -1));

        dcc_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dcc_q.setText("0");
        premium_p.add(dcc_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 30, -1));

        dcc_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcc_m.setText("-");
        dcc_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        dcc_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcc_mActionPerformed(evt);
            }
        });
        premium_p.add(dcc_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 60, -1));

        dcc_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcc_add.setText("Add");
        dcc_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        dcc_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcc_addActionPerformed(evt);
            }
        });
        premium_p.add(dcc_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 90, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel32.setText("Oreo Chocolate");
        premium_p.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 110, -1));

        oc_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        oc_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        oc_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oc_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oc_sActionPerformed(evt);
            }
        });
        premium_p.add(oc_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 110, 30));

        oc_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oc_a.setText("+");
        oc_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        oc_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oc_aActionPerformed(evt);
            }
        });
        premium_p.add(oc_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 60, -1));

        oc_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        oc_q.setText("0");
        premium_p.add(oc_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 30, -1));

        oc_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oc_m.setText("-");
        oc_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        oc_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oc_mActionPerformed(evt);
            }
        });
        premium_p.add(oc_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 60, -1));

        oc_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oc_add.setText("Add");
        oc_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        oc_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oc_addActionPerformed(evt);
            }
        });
        premium_p.add(oc_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 90, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel34.setText("Salted Caramel");
        premium_p.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 120, -1));

        scaramel_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        scaramel_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        scaramel_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scaramel_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaramel_sActionPerformed(evt);
            }
        });
        premium_p.add(scaramel_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 110, 30));

        sc1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc1_a.setText("+");
        sc1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sc1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc1_aActionPerformed(evt);
            }
        });
        premium_p.add(sc1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 60, -1));

        sc1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc1_m.setText("-");
        sc1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sc1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc1_mActionPerformed(evt);
            }
        });
        premium_p.add(sc1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 60, -1));

        sc1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sc1_q.setText("0");
        premium_p.add(sc1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 30, -1));

        sc1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sc1_add.setText("Add");
        sc1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        sc1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sc1_addActionPerformed(evt);
            }
        });
        premium_p.add(sc1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 90, 30));
        premium_p.add(sc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        premium_p.add(super_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 20));
        premium_p.add(occ_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, 30));
        premium_p.add(bsu_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 40, 20));
        premium_p.add(ms_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 40, 20));
        premium_p.add(dc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 40, 30));
        premium_p.add(dcc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 40, 20));
        premium_p.add(oc_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 40, 30));
        premium_p.add(sc1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 194, 40, 20));
        premium_p.add(super_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 40, 20));
        premium_p.add(occ_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 30, 20));
        premium_p.add(bsu_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 30, 30));
        premium_p.add(ms_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 40, 30));
        premium_p.add(dc_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 30, 20));
        premium_p.add(dcc_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 30, 30));
        premium_p.add(oc_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 40, 30));
        premium_p.add(sc1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 40, 30));

        jTabbedPane1.addTab("Premium", premium_p);

        house_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel36.setText("Oreo Overload");
        house_p.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 110, -1));

        oo_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        oo_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        oo_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oo_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oo_sActionPerformed(evt);
            }
        });
        house_p.add(oo_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 30));

        oo_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oo_a.setText("+");
        oo_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        oo_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oo_aActionPerformed(evt);
            }
        });
        house_p.add(oo_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, -1));

        oo_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        oo_q.setText("0");
        house_p.add(oo_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, -1));

        oo_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oo_m.setText("-");
        oo_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        oo_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oo_mActionPerformed(evt);
            }
        });
        house_p.add(oo_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        oo_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oo_add.setText("Add");
        oo_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        oo_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oo_addActionPerformed(evt);
            }
        });
        house_p.add(oo_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel38.setText("Nutella Special");
        house_p.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 110, -1));

        ns_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ns_a.setText("+");
        ns_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ns_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ns_aActionPerformed(evt);
            }
        });
        house_p.add(ns_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 60, -1));

        ns_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ns_q.setText("0");
        house_p.add(ns_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 30, -1));

        ns_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ns_m.setText("-");
        ns_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ns_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ns_mActionPerformed(evt);
            }
        });
        house_p.add(ns_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 60, -1));

        ns_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ns_add.setText("Add");
        ns_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ns_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ns_addActionPerformed(evt);
            }
        });
        house_p.add(ns_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 30));

        ns_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ns_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ns_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ns_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ns_sActionPerformed(evt);
            }
        });
        house_p.add(ns_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel40.setText("Wintermelon Milk ");
        house_p.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        wm_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        wm_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        wm_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        wm_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wm_sActionPerformed(evt);
            }
        });
        house_p.add(wm_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 110, 30));

        wm_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wm_a.setText("+");
        wm_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        wm_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wm_aActionPerformed(evt);
            }
        });
        house_p.add(wm_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 60, -1));

        wm_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wm_q.setText("0");
        house_p.add(wm_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 30, 20));

        wm_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wm_m.setText("-");
        wm_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        wm_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wm_mActionPerformed(evt);
            }
        });
        house_p.add(wm_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 60, -1));

        wm_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wm_add.setText("Add");
        wm_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        wm_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wm_addActionPerformed(evt);
            }
        });
        house_p.add(wm_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel42.setText("Chocoberry");
        house_p.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 90, -1));

        cb_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        cb_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        cb_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cb_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sActionPerformed(evt);
            }
        });
        house_p.add(cb_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 110, 30));

        c_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_a.setText("+");
        c_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        c_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_aActionPerformed(evt);
            }
        });
        house_p.add(c_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 60, -1));

        c_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        c_q.setText("0");
        house_p.add(c_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 30, -1));

        c_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_m.setText("-");
        c_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        c_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_mActionPerformed(evt);
            }
        });
        house_p.add(c_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 60, -1));

        cb_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_add.setText("Add");
        cb_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        cb_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_addActionPerformed(evt);
            }
        });
        house_p.add(cb_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 90, 30));
        house_p.add(oo_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 20));
        house_p.add(ns_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, 30));
        house_p.add(wm_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 40, 20));
        house_p.add(c_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 40, 30));
        house_p.add(oo_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 40, 30));
        house_p.add(ns_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 40, 20));
        house_p.add(wm_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 40, 30));
        house_p.add(c_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 40, 30));

        jTabbedPane1.addTab("House special", house_p);

        ga1_t.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel44.setText("Green Apple ");
        ga1_t.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        ga1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga1_a.setText(" + ");
        ga1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ga1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga1_aActionPerformed(evt);
            }
        });
        ga1_t.add(ga1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, -1));

        ga1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ga1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ga1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ga1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga1_sActionPerformed(evt);
            }
        });
        ga1_t.add(ga1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 30));

        ga1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ga1_q.setText("0");
        ga1_t.add(ga1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, -1));

        ga1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga1_m.setText("-");
        ga1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ga1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga1_mActionPerformed(evt);
            }
        });
        ga1_t.add(ga1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        ga1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga1_add.setText("Add");
        ga1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ga1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga1_addActionPerformed(evt);
            }
        });
        ga1_t.add(ga1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel46.setText("Strawberry ");
        ga1_t.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        s1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        s1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        s1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        s1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_sActionPerformed(evt);
            }
        });
        ga1_t.add(s1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        s1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s1_a.setText("+");
        s1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        s1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_aActionPerformed(evt);
            }
        });
        ga1_t.add(s1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 60, -1));

        s1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        s1_q.setText("0");
        ga1_t.add(s1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 30, -1));

        s1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s1_m.setText("-");
        s1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ga1_t.add(s1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 60, -1));

        s1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s1_add.setText("Add");
        s1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        s1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1_addActionPerformed(evt);
            }
        });
        ga1_t.add(s1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel48.setText("Passion Fruit");
        ga1_t.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, -1));

        ps1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ps1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ps1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ps1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ps1_sActionPerformed(evt);
            }
        });
        ga1_t.add(ps1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 110, 30));

        pf1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf1_a.setText("+");
        pf1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pf1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf1_aActionPerformed(evt);
            }
        });
        ga1_t.add(pf1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 60, -1));

        pf1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pf1_q.setText("0");
        ga1_t.add(pf1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 30, 20));

        pf1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf1_m.setText("-");
        pf1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pf1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf1_mActionPerformed(evt);
            }
        });
        ga1_t.add(pf1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 60, -1));

        pf1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf1_add.setText("Add");
        pf1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        pf1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf1_addActionPerformed(evt);
            }
        });
        ga1_t.add(pf1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel50.setText("Lychee");
        ga1_t.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 60, -1));

        l1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        l1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        l1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        l1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1_sActionPerformed(evt);
            }
        });
        ga1_t.add(l1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 110, 30));

        l1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1_a.setText("+");
        l1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        l1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1_aActionPerformed(evt);
            }
        });
        ga1_t.add(l1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 60, -1));

        l1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l1_q.setText("0");
        ga1_t.add(l1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 30, -1));

        l1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1_m.setText("-");
        l1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        l1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1_mActionPerformed(evt);
            }
        });
        ga1_t.add(l1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 60, -1));

        l1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1_add.setText("Add");
        l1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        l1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1_addActionPerformed(evt);
            }
        });
        ga1_t.add(l1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 80, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel52.setText("Lemon");
        ga1_t.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 60, -1));

        ln1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ln1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ln1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ln1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1_sActionPerformed(evt);
            }
        });
        ga1_t.add(ln1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, 30));

        ln1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln1_a.setText("+");
        ln1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ln1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1_aActionPerformed(evt);
            }
        });
        ga1_t.add(ln1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 60, -1));

        ln1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ln1_q.setText("0");
        ga1_t.add(ln1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 40, -1));

        ln1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln1_m.setText("-");
        ln1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ln1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1_mActionPerformed(evt);
            }
        });
        ga1_t.add(ln1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 60, -1));

        ln1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln1_add.setText("Add");
        ln1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ln1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln1_addActionPerformed(evt);
            }
        });
        ga1_t.add(ln1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 90, 30));

        jLabel54.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel54.setText("Blueberry");
        ga1_t.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 80, -1));

        b1_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        b1_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        b1_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b1_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_sActionPerformed(evt);
            }
        });
        ga1_t.add(b1_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 110, 30));

        bb1_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bb1_a.setText("+");
        bb1_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bb1_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bb1_aActionPerformed(evt);
            }
        });
        ga1_t.add(bb1_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 60, -1));

        b1_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        b1_q.setText("0");
        ga1_t.add(b1_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 40, -1));

        bb1_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bb1_m.setText("-");
        bb1_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bb1_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bb1_mActionPerformed(evt);
            }
        });
        ga1_t.add(bb1_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 60, -1));

        bb1_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bb1_add.setText("Add");
        bb1_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        bb1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bb1_addActionPerformed(evt);
            }
        });
        ga1_t.add(bb1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 90, 30));
        ga1_t.add(ga1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 40, 20));
        ga1_t.add(s1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 40, 30));
        ga1_t.add(pf1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 30, 30));
        ga1_t.add(l1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 30, 20));
        ga1_t.add(ln1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 40, 20));
        ga1_t.add(bb1_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 50, 30));
        ga1_t.add(ga_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 40, 20));
        ga1_t.add(s1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 40, 30));
        ga1_t.add(pf1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 40, 20));
        ga1_t.add(l1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 30, 20));
        ga1_t.add(ln1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 30, 30));
        ga1_t.add(bb1_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 40, 20));

        jTabbedPane1.addTab("Yogurt", ga1_t);

        cheesecake_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel56.setText("Oreo");
        cheesecake_p.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 40, -1));

        o_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        o_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        o_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        o_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_sActionPerformed(evt);
            }
        });
        cheesecake_p.add(o_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 110, 30));

        o_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        o_a.setText("+");
        o_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        o_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_aActionPerformed(evt);
            }
        });
        cheesecake_p.add(o_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        o_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        o_q.setText("0");
        cheesecake_p.add(o_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 30, 20));

        o_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        o_m.setText("-");
        o_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        o_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_mActionPerformed(evt);
            }
        });
        cheesecake_p.add(o_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, -1));

        o_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        o_add.setText("Add");
        o_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        o_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_addActionPerformed(evt);
            }
        });
        cheesecake_p.add(o_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel58.setText("Nutella Hazelnut");
        cheesecake_p.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 120, -1));

        nh_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        nh_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        nh_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nh_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nh_sActionPerformed(evt);
            }
        });
        cheesecake_p.add(nh_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        nh_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nh_a.setText("+");
        nh_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nh_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nh_aActionPerformed(evt);
            }
        });
        cheesecake_p.add(nh_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, -1));

        nh_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nh_q.setText("0");
        cheesecake_p.add(nh_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 30, -1));

        nh_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nh_m.setText("-");
        nh_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nh_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nh_mActionPerformed(evt);
            }
        });
        cheesecake_p.add(nh_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, -1));

        nh_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nh_add.setText("Add");
        nh_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        nh_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nh_addActionPerformed(evt);
            }
        });
        cheesecake_p.add(nh_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 90, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel60.setText("Red Velvet");
        cheesecake_p.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 80, -1));

        rv_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        rv_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        rv_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rv_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rv_sActionPerformed(evt);
            }
        });
        cheesecake_p.add(rv_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 110, 30));

        rv_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rv_a.setText("+");
        rv_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        rv_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rv_aActionPerformed(evt);
            }
        });
        cheesecake_p.add(rv_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 60, -1));

        rv_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rv_q.setText("0");
        cheesecake_p.add(rv_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 30, -1));

        rv_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rv_m.setText("-");
        rv_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        rv_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rv_mActionPerformed(evt);
            }
        });
        cheesecake_p.add(rv_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 60, -1));

        rv_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rv_add.setText("Add");
        rv_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        rv_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rv_addActionPerformed(evt);
            }
        });
        cheesecake_p.add(rv_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 90, 30));

        jLabel62.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel62.setText("Chocoloco");
        cheesecake_p.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, -1));

        clo_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        clo_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        clo_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clo_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clo_sActionPerformed(evt);
            }
        });
        cheesecake_p.add(clo_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 110, 30));

        cl_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cl_a.setText("+");
        cl_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cl_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_aActionPerformed(evt);
            }
        });
        cheesecake_p.add(cl_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 60, -1));

        cl_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cl_q.setText("0");
        cheesecake_p.add(cl_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 30, -1));

        cl_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cl_m.setText("-");
        cl_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cl_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_mActionPerformed(evt);
            }
        });
        cheesecake_p.add(cl_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, 60, -1));

        cl_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cl_add.setText("Add");
        cl_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        cl_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl_addActionPerformed(evt);
            }
        });
        cheesecake_p.add(cl_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 90, 30));
        cheesecake_p.add(o_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 40, 20));
        cheesecake_p.add(nh_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 30, 30));
        cheesecake_p.add(rv_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 30, 20));
        cheesecake_p.add(cl_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 40, 30));
        cheesecake_p.add(o_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 30, 30));
        cheesecake_p.add(nh_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 40, 20));
        cheesecake_p.add(rv_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 30, 20));
        cheesecake_p.add(cl_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 40, 30));

        jTabbedPane1.addTab("Cheesecake", cheesecake_p);

        nuttela_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel64.setText("Oreo Nutella");
        nuttela_p.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, -1));

        on_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        on_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        on_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        on_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_sActionPerformed(evt);
            }
        });
        nuttela_p.add(on_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 110, 30));

        on_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        on_a.setText("+");
        on_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        on_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_aActionPerformed(evt);
            }
        });
        nuttela_p.add(on_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        on_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        on_q.setText("0");
        nuttela_p.add(on_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 30, -1));

        on_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        on_m.setText("-");
        on_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        on_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_mActionPerformed(evt);
            }
        });
        nuttela_p.add(on_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 60, -1));

        on_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        on_add.setText("Add");
        on_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        on_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                on_addActionPerformed(evt);
            }
        });
        nuttela_p.add(on_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 30));

        jLabel66.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel66.setText("Nutella Velvet");
        nuttela_p.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 100, -1));

        nv_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        nv_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        nv_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nv_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nv_sActionPerformed(evt);
            }
        });
        nuttela_p.add(nv_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 110, 30));

        nv_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nv_a.setText("+");
        nv_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nv_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nv_aActionPerformed(evt);
            }
        });
        nuttela_p.add(nv_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, -1));

        nv_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nv_q.setText("0");
        nuttela_p.add(nv_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 30, 20));

        nv_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nv_m.setText("-");
        nv_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nv_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nv_mActionPerformed(evt);
            }
        });
        nuttela_p.add(nv_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, -1));

        nv_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nv_add.setText("Add");
        nv_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        nv_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nv_addActionPerformed(evt);
            }
        });
        nuttela_p.add(nv_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 90, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel68.setText("Choco Nutella");
        nuttela_p.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 110, -1));

        cn_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        cn_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        cn_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cn_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cn_sActionPerformed(evt);
            }
        });
        nuttela_p.add(cn_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 30));

        cn_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cn_a.setText("+");
        cn_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cn_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cn_aActionPerformed(evt);
            }
        });
        nuttela_p.add(cn_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 60, -1));

        cn_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cn_q.setText("0");
        nuttela_p.add(cn_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 30, -1));

        cn_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cn_m.setText("-");
        cn_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cn_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cn_mActionPerformed(evt);
            }
        });
        nuttela_p.add(cn_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 60, -1));

        cn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cn_add.setText("Add");
        cn_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        cn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cn_addActionPerformed(evt);
            }
        });
        nuttela_p.add(cn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 90, 30));

        jLabel70.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel70.setText("Nutella Berry ");
        nuttela_p.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        nb_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        nb_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        nb_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nb_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nb_sActionPerformed(evt);
            }
        });
        nuttela_p.add(nb_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 110, 30));

        nb_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nb_a.setText("+");
        nb_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nb_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nb_aActionPerformed(evt);
            }
        });
        nuttela_p.add(nb_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 60, -1));

        nb_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nb_q.setText("0");
        nuttela_p.add(nb_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 30, -1));

        nb_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nb_m.setText("-");
        nb_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nb_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nb_mActionPerformed(evt);
            }
        });
        nuttela_p.add(nb_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 60, -1));

        nb_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nb_add.setText("Add");
        nb_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        nb_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nb_addActionPerformed(evt);
            }
        });
        nuttela_p.add(nb_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 90, 30));
        nuttela_p.add(on_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 40, 30));
        nuttela_p.add(nv_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 30, 20));
        nuttela_p.add(cn_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 40, 30));
        nuttela_p.add(nb_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 30, 30));
        nuttela_p.add(on_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 40, 30));
        nuttela_p.add(nv_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 30, 20));
        nuttela_p.add(cn_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 30, 30));
        nuttela_p.add(nb_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 40, 30));

        jTabbedPane1.addTab("Nuttela", nuttela_p);

        fruit_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel72.setText("Green Apple");
        fruit_p.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 90, -1));

        ga2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ga2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ga2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ga2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga2_sActionPerformed(evt);
            }
        });
        fruit_p.add(ga2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 110, 30));

        ga_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga_a.setText("+");
        ga_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ga_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga_aActionPerformed(evt);
            }
        });
        fruit_p.add(ga_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        ga_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ga_q.setText("0");
        fruit_p.add(ga_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, -1));

        ga_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga_m.setText("-");
        ga_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ga_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga_mActionPerformed(evt);
            }
        });
        fruit_p.add(ga_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        ga_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ga_add.setText("Add");
        ga_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ga_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ga_addActionPerformed(evt);
            }
        });
        fruit_p.add(ga_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, 30));

        jLabel74.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel74.setText("Strawberry");
        fruit_p.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 90, -1));

        s_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s_a.setText("+");
        s_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        s_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_aActionPerformed(evt);
            }
        });
        fruit_p.add(s_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 60, -1));

        s_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        s_q.setText("0");
        fruit_p.add(s_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 30, -1));

        s_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s_m.setText("-");
        s_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        s_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_mActionPerformed(evt);
            }
        });
        fruit_p.add(s_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, -1));

        s_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        s_add.setText("Add");
        s_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        s_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_addActionPerformed(evt);
            }
        });
        fruit_p.add(s_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 90, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel76.setText("Passion Fruit");
        fruit_p.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 90, -1));

        p2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        p2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        p2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2_sActionPerformed(evt);
            }
        });
        fruit_p.add(p2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 30));

        pf_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf_a.setText("+");
        pf_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pf_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_aActionPerformed(evt);
            }
        });
        fruit_p.add(pf_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 60, -1));

        pf_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf_m.setText("-");
        pf_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pf_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_mActionPerformed(evt);
            }
        });
        fruit_p.add(pf_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 60, -1));

        pf_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pf_q.setText("0");
        fruit_p.add(pf_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 30, -1));

        pf_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf_add.setText("Add");
        pf_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        pf_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_addActionPerformed(evt);
            }
        });
        fruit_p.add(pf_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 90, 30));

        jLabel78.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel78.setText("lychee");
        fruit_p.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 50, 20));

        l2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        l2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        l2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        l2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2_sActionPerformed(evt);
            }
        });
        fruit_p.add(l2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

        l_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_a.setText("+");
        l_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        l_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_aActionPerformed(evt);
            }
        });
        fruit_p.add(l_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 60, -1));

        l_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_q.setText("0");
        fruit_p.add(l_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 30, -1));

        l_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_m.setText("-");
        l_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        l_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_mActionPerformed(evt);
            }
        });
        fruit_p.add(l_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 60, -1));

        l_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_add.setText("Add");
        l_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        l_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_addActionPerformed(evt);
            }
        });
        fruit_p.add(l_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 90, 30));

        jLabel80.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel80.setText("Lemon ");
        fruit_p.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        ln2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        ln2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        ln2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ln2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln2_sActionPerformed(evt);
            }
        });
        fruit_p.add(ln2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, 30));

        ln_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln_a.setText("+");
        ln_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ln_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln_aActionPerformed(evt);
            }
        });
        fruit_p.add(ln_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, -1));

        ln_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ln_q.setText("0");
        fruit_p.add(ln_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 30, 20));

        ln_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln_m.setText("-");
        ln_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ln_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln_mActionPerformed(evt);
            }
        });
        fruit_p.add(ln_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 60, -1));

        ln_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ln_add.setText("Add");
        ln_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ln_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ln_addActionPerformed(evt);
            }
        });
        fruit_p.add(ln_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 90, 30));

        jLabel82.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel82.setText("Blueberry");
        fruit_p.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 90, -1));

        b2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        b2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        b2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_sActionPerformed(evt);
            }
        });
        fruit_p.add(b2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 110, 30));

        b_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_a.setText("+");
        b_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        b_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_aActionPerformed(evt);
            }
        });
        fruit_p.add(b_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 60, -1));

        b_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        b_q.setText("0");
        fruit_p.add(b_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 30, 20));

        b_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_m.setText("-");
        b_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        b_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_mActionPerformed(evt);
            }
        });
        fruit_p.add(b_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 60, -1));

        b_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_add.setText("Add");
        b_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });
        fruit_p.add(b_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 90, 30));

        s2_s.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        s2_s.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "size" }));
        s2_s.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        s2_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2_sActionPerformed(evt);
            }
        });
        fruit_p.add(s2_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 110, 30));
        fruit_p.add(ga_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 30, 20));
        fruit_p.add(s_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 40, 20));
        fruit_p.add(pf_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 40, 20));
        fruit_p.add(l_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 30, 20));
        fruit_p.add(ln_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 40, 30));
        fruit_p.add(b_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 30, 20));
        fruit_p.add(ga_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 40, 30));
        fruit_p.add(s_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 30, 30));
        fruit_p.add(pf_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 30, 30));
        fruit_p.add(l_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 40, 30));
        fruit_p.add(ln_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 40, 30));
        fruit_p.add(b_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 40, 20));

        jTabbedPane1.addTab("Fruit tea", fruit_p);

        addtional_p.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel84.setText("Sinkers");
        addtional_p.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 60, -1));

        sinker_i.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        sinker_i.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "others" }));
        sinker_i.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sinker_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinker_iActionPerformed(evt);
            }
        });
        addtional_p.add(sinker_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, 30));

        sinkers_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sinkers_a.setText("+");
        sinkers_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sinkers_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinkers_aActionPerformed(evt);
            }
        });
        addtional_p.add(sinkers_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, -1));

        sinkers_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sinkers_q.setText("0");
        addtional_p.add(sinkers_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 40, 20));

        sinkers_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sinkers_m.setText("-");
        sinkers_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sinkers_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinkers_mActionPerformed(evt);
            }
        });
        addtional_p.add(sinkers_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 60, -1));

        sinkers_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sinkers_add.setText("Add");
        sinkers_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        sinkers_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinkers_addActionPerformed(evt);
            }
        });
        addtional_p.add(sinkers_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 90, 30));
        addtional_p.add(sinkers_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 30, 20));

        jLabel86.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel86.setText("Toppings");
        addtional_p.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 80, -1));
        addtional_p.add(sinkers_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 30, 30));

        topp_i.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        topp_i.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "others" }));
        topp_i.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        topp_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topp_iActionPerformed(evt);
            }
        });
        addtional_p.add(topp_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 140, 30));

        topp_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        topp_a.setText("+");
        topp_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        topp_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topp_aActionPerformed(evt);
            }
        });
        addtional_p.add(topp_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 60, -1));

        topp_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        topp_q.setText("0");
        addtional_p.add(topp_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 40, -1));

        topp_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        topp_m.setText("-");
        topp_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        topp_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topp_mActionPerformed(evt);
            }
        });
        addtional_p.add(topp_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 60, -1));
        addtional_p.add(topp_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 40, 30));

        jLabel88.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel88.setText("Additional");
        addtional_p.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 80, -1));

        add_i.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        add_i.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "others" }));
        add_i.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_iActionPerformed(evt);
            }
        });
        addtional_p.add(add_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 140, 30));

        add_a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add_a.setText("+");
        add_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        add_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_aActionPerformed(evt);
            }
        });
        addtional_p.add(add_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 60, -1));

        add_q.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_q.setText("0");
        addtional_p.add(add_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 30, -1));

        add_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add_m.setText("-");
        add_m.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        add_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_mActionPerformed(evt);
            }
        });
        addtional_p.add(add_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 60, -1));

        add_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add_add.setText("Add");
        add_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        add_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_addActionPerformed(evt);
            }
        });
        addtional_p.add(add_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 90, 30));

        topp_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        topp_add.setText("Add");
        topp_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        topp_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topp_addActionPerformed(evt);
            }
        });
        addtional_p.add(topp_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 90, 30));
        addtional_p.add(topp_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 40, 20));
        addtional_p.add(add_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 40, 30));
        addtional_p.add(add_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 30, 30));

        jTabbedPane1.addTab("Add Ons ", addtional_p);

        jPanel13.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 350));

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        ORDERS_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product_name", "size", "price", "quantity", "totalprice"
            }
        ));
        jScrollPane1.setViewportView(ORDERS_TABLE);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 200));

        jTabbedPane2.addTab("Orders", jPanel9);

        jPanel10.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 230));

        t.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        t.setText("Total purchase  :");
        jPanel10.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 150, 30));

        txttotal.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        txttotal.setText("00");
        jPanel10.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 30, 50));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel11.setText(" Cash :");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 50, 30));

        txtpay.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        txtpay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
            }
        });
        jPanel10.add(txtpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 140, 30));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel12.setText("Change :");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, 30));

        txtbal.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        txtbal.setText("00");
        jPanel10.add(txtbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 30, 30));

        payment_b.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        payment_b.setText("Pay ");
        payment_b.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payment_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_bActionPerformed(evt);
            }
        });
        jPanel10.add(payment_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 90, 30));

        delete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        delete.setText("Cancel Order");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel10.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, 100, 30));
        jPanel10.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 40));

        jButton3.setText("remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 80, 20));

        UPDATE_TABLE.setText("update");
        UPDATE_TABLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_TABLEActionPerformed(evt);
            }
        });
        jPanel10.add(UPDATE_TABLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 80, 20));

        jPanel13.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 1000, 300));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setAutoscrolls(true);
        jPanel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtbill.setRows(5);
        jScrollPane2.setViewportView(txtbill);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 570));

        jPanel13.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 340, 590));

        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton1.setText("Print Receipt");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 110, 40));

        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 630, 130, 40));

        jDesktopPane2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 680));

        getContentPane().add(jDesktopPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 680));

        jMenu1.setText("Sales");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Saved Purchase");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sc_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Super Chocolate"; // 
        String size = (String) super_s.getSelectedItem();

        double price1 = Double.parseDouble(super_p.getText());
        int quantity = Integer.parseInt(sc_q.getText());

        super_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        super_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        sc_q.setText("0");
        super_t.setVisible(false);
        txt();

    }//GEN-LAST:event_sc_addActionPerformed

    private void s1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Strawberry"; // 
        String size = (String) s1_s.getSelectedItem();

        double price1 = Double.parseDouble(s1_p.getText());
        int quantity = Integer.parseInt(s1_q.getText());

        s1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        s1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        s1_q.setText("0");
        s1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_s1_addActionPerformed

    private void cheese_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheese_sActionPerformed
        cheese();
        cheese_p.setVisible(false);

    }//GEN-LAST:event_cheese_sActionPerformed

    private void cheese_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheese_aActionPerformed
        // TODO add your handling code here:

        int i = Integer.valueOf(cheese_q.getText());
        ++i;
        cheese_q.setText(String.valueOf(i));


    }//GEN-LAST:event_cheese_aActionPerformed

    private void cheese_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cheese_sMouseClicked
        // TODO add your handling code here:q AD

    }//GEN-LAST:event_cheese_sMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        conn = (Connection) DBCONNECTION.getConnection();

        sizes();
    }//GEN-LAST:event_formWindowOpened

    private void b_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(b_q.getText());
        --i;
        b_q.setText(String.valueOf(i));
    }//GEN-LAST:event_b_mActionPerformed

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Blueberry"; // 
        String size = (String) b2_s.getSelectedItem();

        double price1 = Double.parseDouble(b_p.getText());
        int quantity = Integer.parseInt(b_q.getText());

        b2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        b_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        b_q.setText("0");
        b_t.setVisible(false);
        txt();
    }//GEN-LAST:event_b_addActionPerformed

    private void sinkers_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinkers_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(sinkers_q.getText());
        ++i;
        sinkers_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sinkers_aActionPerformed

    private void c_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_addActionPerformed
        // TODO add your handling code here

//        String product_Name = product_c.getText();
//        String size = (String) cheese_s.getSelectedItem();
//
//        double price1 = Double.parseDouble(cheese_p.getText());
//        int quantity = Integer.parseInt(cheese_q.getText());
//
//        cheese_s.setSelectedIndex(1);
//
//        double totalprice = price1 * quantity;
//
//        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
//        model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        String product_Name = product_c.getText();
        String size = (String) cheese_s.getSelectedItem();
        double price1 = Double.parseDouble(cheese_p.getText());
        int quantity = Integer.parseInt(cheese_q.getText());

        cheese_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();

        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        cheese_q.setText("0");
        cheese_t.setVisible(false);
        txt();


    }//GEN-LAST:event_c_addActionPerformed

    private void pepperoni_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoni_sActionPerformed
        // TODO add your handling code here:
        pepperoniprice();
        pepperoni_p.setVisible(false);
    }//GEN-LAST:event_pepperoni_sActionPerformed

    private void chicken_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chicken_sActionPerformed
        // TODO add your handling code here:
        chickenhawaiin();
        chicken_p.setVisible(false);
    }//GEN-LAST:event_chicken_sActionPerformed

    private void cheese_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheese_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(cheese_q.getText());
        --i;
        cheese_q.setText(String.valueOf(i));


    }//GEN-LAST:event_cheese_mActionPerformed

    private void sinkers_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinkers_addActionPerformed
        // TODO add your handling code here:

        String product_Name = (String) sinker_i.getSelectedItem();
        String size = "-------";
        double price1 = Double.parseDouble(sinkers_p.getText());
        int quantity = Integer.parseInt(sinkers_q.getText());

        sinker_i.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        sinkers_t.setText(String.valueOf(totalprice));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        sinkers_q.setText("0");
        sinkers_t.setVisible(false);
        txt();
    }//GEN-LAST:event_sinkers_addActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void payment_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_bActionPerformed
        // TODO add your handling code here:

//        pay();
        bill();

        save_purchase();
        txttotal.setText("00");
        txtpay.setText("");
        txtbal.setText("00");

    }//GEN-LAST:event_payment_bActionPerformed

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtpayActionPerformed

    private void pepperoni_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoni_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pepperoni_q.getText());
        ++i;
        pepperoni_q.setText(String.valueOf(i));

    }//GEN-LAST:event_pepperoni_aActionPerformed

    private void pepperoni_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pepperoni_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pepperoni_q.getText());
        --i;
        pepperoni_q.setText(String.valueOf(i));
    }//GEN-LAST:event_pepperoni_mActionPerformed

    private void p_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Pepperoni";
        String size = (String) pepperoni_s.getSelectedItem();

        double price1 = Double.parseDouble(pepperoni_p.getText());
        int quantity = Integer.parseInt(pepperoni_q.getText());

        pepperoni_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        p_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();

        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        pepperoni_q.setText("0");
        p_t.setVisible(false);
        txt();

    }//GEN-LAST:event_p_addActionPerformed

    private void chicken_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chicken_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(chicken_q.getText());
        ++i;
        chicken_q.setText(String.valueOf(i));

    }//GEN-LAST:event_chicken_aActionPerformed

    private void chicken_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chicken_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(chicken_q.getText());
        --i;
        chicken_q.setText(String.valueOf(i));

    }//GEN-LAST:event_chicken_mActionPerformed

    private void ch_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Chicken Hawaiin"; // 
        String size = (String) chicken_s.getSelectedItem();

        double price1 = Double.parseDouble(chicken_p.getText());
        int quantity = Integer.parseInt(chicken_q.getText());

        chicken_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ch_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();

        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        chicken_q.setText("0");
        ch_t.setVisible(false);
        txt();
    }//GEN-LAST:event_ch_addActionPerformed

    private void veggies_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veggies_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(veggies_q.getText());
        --i;
        veggies_q.setText(String.valueOf(i));
    }//GEN-LAST:event_veggies_mActionPerformed

    private void veggies_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veggies_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(veggies_q.getText());
        ++i;
        veggies_q.setText(String.valueOf(i));
    }//GEN-LAST:event_veggies_aActionPerformed

    private void oo_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oo_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(oo_q.getText());
        --i;
        oo_q.setText(String.valueOf(i));
    }//GEN-LAST:event_oo_mActionPerformed

    private void sc1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc1_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Salted Caramel"; // 
        String size = (String) scaramel_s.getSelectedItem();

        double price1 = Double.parseDouble(sc1_p.getText());
        int quantity = Integer.parseInt(sc1_q.getText());

        scaramel_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        sc1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        sc1_q.setText("0");
        sc1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_sc1_addActionPerformed

    private void sc1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc1_aActionPerformed
        // TODO add your handling code here
        // TODO add your handling code here:
        int i = Integer.valueOf(sc1_q.getText());
        ++i;
        sc1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sc1_aActionPerformed

    private void occ_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occ_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(occ_q.getText());
        ++i;
        occ_q.setText(String.valueOf(i));
    }//GEN-LAST:event_occ_aActionPerformed

    private void sc_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(sc_q.getText());
        ++i;
        sc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sc_aActionPerformed

    private void veggies_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veggies_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Veggies"; // 
        String size = (String) veggies_s.getSelectedItem();

        double price1 = Double.parseDouble(veggies_p.getText());
        int quantity = Integer.parseInt(veggies_q.getText());

        veggies_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        v_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        veggies_q.setText("0");
        v_t.setVisible(false);
        txt();
    }//GEN-LAST:event_veggies_addActionPerformed

    private void veggies_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veggies_sActionPerformed
        // TODO add your handling code here:
        veggies();
        veggies_p.setVisible(false);
    }//GEN-LAST:event_veggies_sActionPerformed

    private void sc_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(sc_q.getText());
        --i;
        sc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sc_mActionPerformed

    private void super_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_super_sActionPerformed
        // TODO add your handling code here:
        superchocolate();
        super_p.setVisible(false);
    }//GEN-LAST:event_super_sActionPerformed

    private void occ_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occ_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(occ_q.getText());
        --i;
        occ_q.setText(String.valueOf(i));
    }//GEN-LAST:event_occ_mActionPerformed

    private void occ_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occ_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Oreo coockies & Cream"; // 
        String size = (String) occ_s.getSelectedItem();

        double price1 = Double.parseDouble(occ_p.getText());
        int quantity = Integer.parseInt(occ_q.getText());

        occ_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        occ_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        occ_q.setText("0");
        occ_t.setVisible(false);
        txt();
    }//GEN-LAST:event_occ_addActionPerformed

    private void occ_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occ_sActionPerformed
        // TODO add your handling code here:
        oreocookies();
        occ_p.setVisible(false);
    }//GEN-LAST:event_occ_sActionPerformed

    private void bsu_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsu_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(bsu_q.getText());
        ++i;
        bsu_q.setText(String.valueOf(i));
    }//GEN-LAST:event_bsu_aActionPerformed

    private void bsu_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsu_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(bsu_q.getText());
        --i;
        bsu_q.setText(String.valueOf(i));
    }//GEN-LAST:event_bsu_mActionPerformed

    private void bsu_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsu_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Brown Sugar Ukinawa"; // 
        String size = (String) bsu_s.getSelectedItem();

        double price1 = Double.parseDouble(bsu_p.getText());
        int quantity = Integer.parseInt(bsu_q.getText());

        bsu_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        bsu_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        bsu_q.setText("0");
        bsu_t.setVisible(false);
        txt();
    }//GEN-LAST:event_bsu_addActionPerformed

    private void bsu_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsu_sActionPerformed
        // TODO add your handling code here:
        brownsugar();
        bsu_p.setVisible(false);
    }//GEN-LAST:event_bsu_sActionPerformed

    private void ms_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ms_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ms_q.getText());
        ++i;
        ms_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ms_aActionPerformed

    private void ms_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ms_mActionPerformed
        // TODO add your handling code here:

        int i = Integer.valueOf(ms_q.getText());
        --i;
        ms_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ms_mActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:

        String product_Name = "Milky Strawberry"; // 
        String size = (String) ms_s.getSelectedItem();

        double price1 = Double.parseDouble(ms_p.getText());
        int quantity = Integer.parseInt(ms_q.getText());

        ms_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ms_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ms_q.setText("0");
        ms_t.setVisible(false);
        txt();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void ms_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ms_sActionPerformed
        // TODO add your handling code here:
        milkystrawberry();
        ms_p.setVisible(false);
    }//GEN-LAST:event_ms_sActionPerformed

    private void dc_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Dark Chocolate"; // 
        String size = (String) dc_s.getSelectedItem();

        double price1 = Double.parseDouble(dc_p.getText());
        int quantity = Integer.parseInt(dc_q.getText());

        dc_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        dc_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        dc_q.setText("0");
        dc_t.setVisible(false);
        txt();
    }//GEN-LAST:event_dc_addActionPerformed

    private void dc_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(dc_q.getText());
        ++i;
        dc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_dc_aActionPerformed

    private void dc_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(dc_q.getText());
        --i;
        dc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_dc_mActionPerformed

    private void dc_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dc_sActionPerformed
        // TODO add your handling code here:
        darkchoco();
        dc_p.setVisible(false);
    }//GEN-LAST:event_dc_sActionPerformed

    private void dcc_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcc_sActionPerformed
        // TODO add your handling code here:  darkchoco();
        darkcaramel();
        dcc_p.setVisible(false);


    }//GEN-LAST:event_dcc_sActionPerformed

    private void dcc_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcc_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(dcc_q.getText());
        ++i;
        dcc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_dcc_aActionPerformed

    private void dcc_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcc_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(dcc_q.getText());
        --i;
        dcc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_dcc_mActionPerformed

    private void dcc_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcc_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Dark Choco Caramel"; // 
        String size = (String) dcc_s.getSelectedItem();

        double price1 = Double.parseDouble(dcc_p.getText());
        int quantity = Integer.parseInt(dcc_q.getText());

        dcc_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        dcc_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        dcc_q.setText("0");
        dcc_t.setVisible(false);
        txt();
    }//GEN-LAST:event_dcc_addActionPerformed

    private void oc_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oc_addActionPerformed
        // TODO add your handling code here:

        String product_Name = "Dark Choco Caramel"; // 
        String size = (String) oc_s.getSelectedItem();

        double price1 = Double.parseDouble(oc_p.getText());
        int quantity = Integer.parseInt(oc_q.getText());

        oc_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        oc_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        oc_q.setText("0");
        oc_t.setVisible(false);
        txt();
    }//GEN-LAST:event_oc_addActionPerformed

    private void oc_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oc_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(oc_q.getText());
        ++i;
        oc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_oc_aActionPerformed

    private void oc_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oc_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(oc_q.getText());
        --i;
        oc_q.setText(String.valueOf(i));
    }//GEN-LAST:event_oc_mActionPerformed

    private void oc_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oc_sActionPerformed
        // TODO add your
        oreochoco();
        oc_p.setVisible(false);
    }//GEN-LAST:event_oc_sActionPerformed

    private void sc1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sc1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(sc1_q.getText());
        --i;
        sc1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sc1_mActionPerformed

    private void scaramel_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaramel_sActionPerformed
        // TODO add your handling code here:
        saltedcaramel();
        sc1_p.setVisible(false);
    }//GEN-LAST:event_scaramel_sActionPerformed

    private void oo_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oo_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Oreo Overload"; // 
        String size = (String) oo_s.getSelectedItem();

        double price1 = Double.parseDouble(oo_p.getText());
        int quantity = Integer.parseInt(oo_q.getText());

        oo_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        oo_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        oo_q.setText("0");
        oo_t.setVisible(false);
        txt();
    }//GEN-LAST:event_oo_addActionPerformed

    private void oo_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oo_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(oo_q.getText());
        ++i;
        oo_q.setText(String.valueOf(i));
    }//GEN-LAST:event_oo_aActionPerformed

    private void oo_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oo_sActionPerformed
        // TODO add your handling code here:
        oreooverlaod();
        oo_p.setVisible(false);
    }//GEN-LAST:event_oo_sActionPerformed

    private void ns_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ns_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Nutella Special"; // 
        String size = (String) ns_s.getSelectedItem();

        double price1 = Double.parseDouble(ns_p.getText());
        int quantity = Integer.parseInt(ns_q.getText());

        ns_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ns_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ns_q.setText("0");
        ns_t.setVisible(false);
        txt();
    }//GEN-LAST:event_ns_addActionPerformed

    private void ns_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ns_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ns_q.getText());
        ++i;
        ns_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ns_aActionPerformed

    private void ns_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ns_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ns_q.getText());
        --i;
        ns_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ns_mActionPerformed

    private void ns_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ns_sActionPerformed
        // TODO add your handling code here:
        nutellaspecial();
        ns_p.setVisible(false);
    }//GEN-LAST:event_ns_sActionPerformed

    private void wm_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wm_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(wm_q.getText());
        ++i;
        wm_q.setText(String.valueOf(i));
    }//GEN-LAST:event_wm_aActionPerformed

    private void wm_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wm_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(wm_q.getText());
        --i;
        wm_q.setText(String.valueOf(i));
    }//GEN-LAST:event_wm_mActionPerformed

    private void wm_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wm_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Wintermelon Milk"; // 
        String size = (String) wm_s.getSelectedItem();

        double price1 = Double.parseDouble(wm_p.getText());
        int quantity = Integer.parseInt(wm_q.getText());

        wm_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        wm_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        wm_q.setText("0");
        wm_t.setVisible(false);
        txt();
    }//GEN-LAST:event_wm_addActionPerformed

    private void wm_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wm_sActionPerformed
        // TODO add your handling code here:
        wintermelon();
        wm_p.setVisible(false);
    }//GEN-LAST:event_wm_sActionPerformed

    private void cb_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sActionPerformed

        chocoberry();
        c_p.setVisible(false);
    }//GEN-LAST:event_cb_sActionPerformed

    private void cb_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Chocoberry"; // 
        String size = (String) cb_s.getSelectedItem();

        double price1 = Double.parseDouble(c_p.getText());
        int quantity = Integer.parseInt(c_q.getText());

        cb_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        c_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        c_q.setText("0");
        c_t.setVisible(false);
        txt();
    }//GEN-LAST:event_cb_addActionPerformed

    private void c_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(c_q.getText());
        ++i;
        c_q.setText(String.valueOf(i));
    }//GEN-LAST:event_c_aActionPerformed

    private void c_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(c_q.getText());
        --i;
        c_q.setText(String.valueOf(i));
    }//GEN-LAST:event_c_mActionPerformed

    private void ga1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Green Apple"; // 
        String size = (String) ga1_s.getSelectedItem();

        double price1 = Double.parseDouble(ga1_p.getText());
        int quantity = Integer.parseInt(ga1_q.getText());

        ga1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ga_T.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ga1_q.setText("0");
        ga_T.setVisible(false);
        txt();
    }//GEN-LAST:event_ga1_addActionPerformed

    private void ga_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ga_q.getText());
        ++i;
        ga_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ga_aActionPerformed

    private void ga1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ga1_q.getText());
        ++i;
        ga1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ga1_aActionPerformed

    private void ga1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ga1_q.getText());
        --i;
        ga1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ga1_mActionPerformed

    private void ga1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga1_sActionPerformed
        // TODO add your handling code here:
        ygreenapple();
        ga1_p.setVisible(false);
    }//GEN-LAST:event_ga1_sActionPerformed

    private void s1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_sActionPerformed
        // TODO add your handling code here:
        ystrawberry();
        s1_p.setVisible(false);
    }//GEN-LAST:event_s1_sActionPerformed

    private void s1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(s1_q.getText());
        ++i;
        s1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_s1_aActionPerformed

    private void cl_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Chocoloco"; // 
        String size = (String) clo_s.getSelectedItem();

        double price1 = Double.parseDouble(cl_p.getText());
        int quantity = Integer.parseInt(cl_q.getText());

        clo_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        cl_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        cl_q.setText("0");
        cl_t.setVisible(false);
        txt();
    }//GEN-LAST:event_cl_addActionPerformed

    private void bb1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bb1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Blueberry"; // 
        String size = (String) b1_s.getSelectedItem();

        double price1 = Double.parseDouble(bb1_p.getText());
        int quantity = Integer.parseInt(b1_q.getText());

        b1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        bb1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        b1_q.setText("0");
        bb1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_bb1_addActionPerformed

    private void l1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Lychee"; // 
        String size = (String) l1_s.getSelectedItem();

        double price1 = Double.parseDouble(l1_p.getText());
        int quantity = Integer.parseInt(l1_q.getText());

        l1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        l1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        l1_q.setText("0");
        l1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_l1_addActionPerformed

    private void pf1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = " Passion Fruit"; // 
        String size = (String) ps1_s.getSelectedItem();

        double price1 = Double.parseDouble(pf1_p.getText());
        int quantity = Integer.parseInt(pf1_q.getText());

        ps1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        pf1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        pf1_q.setText("0");
        pf1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_pf1_addActionPerformed

    private void ps1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ps1_sActionPerformed
        // TODO add your handling code here:
        ypassion();
        pf1_p.setVisible(false);
    }//GEN-LAST:event_ps1_sActionPerformed

    private void pf1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pf1_q.getText());
        --i;
        pf1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_pf1_mActionPerformed

    private void pf1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pf1_q.getText());
        ++i;
        pf1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_pf1_aActionPerformed

    private void l1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(l1_q.getText());
        ++i;
        l1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_l1_aActionPerformed

    private void l1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(l1_q.getText());
        --i;
        l1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_l1_mActionPerformed

    private void l1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1_sActionPerformed
        // TODO add your handling code here:
        lychee();
        l1_p.setVisible(false);
    }//GEN-LAST:event_l1_sActionPerformed

    private void ln1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Lemon"; // 
        String size = (String) ln1_s.getSelectedItem();

        double price1 = Double.parseDouble(ln1_p.getText());
        int quantity = Integer.parseInt(ln1_q.getText());

        ln1_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ln1_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ln1_q.setText("0");
        ln1_t.setVisible(false);
        txt();
    }//GEN-LAST:event_ln1_addActionPerformed

    private void ln1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1_sActionPerformed
        // TODO add your handling code here:
        lemon();
        ln1_p.setVisible(false);
    }//GEN-LAST:event_ln1_sActionPerformed

    private void ln1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ln1_q.getText());
        ++i;
        ln1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ln1_aActionPerformed

    private void ln1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ln1_q.getText());
        --i;
        ln1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ln1_mActionPerformed

    private void bb1_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bb1_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(b1_q.getText());
        ++i;
        b1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_bb1_aActionPerformed

    private void bb1_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bb1_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(b1_q.getText());
        --i;
        b1_q.setText(String.valueOf(i));
    }//GEN-LAST:event_bb1_mActionPerformed

    private void o_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Oreo"; // 
        String size = (String) o_s.getSelectedItem();

        double price1 = Double.parseDouble(o_p.getText());
        int quantity = Integer.parseInt(o_q.getText());

        o_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        o_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        o_q.setText("0");
        o_t.setVisible(false);
        txt();
    }//GEN-LAST:event_o_addActionPerformed

    private void b1_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_sActionPerformed
        // TODO add your handling code here:
        blueberry();
        bb1_p.setVisible(false);
    }//GEN-LAST:event_b1_sActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();

        model.setRowCount(0);


    }//GEN-LAST:event_deleteActionPerformed

    private void o_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_sActionPerformed
        // TODO add your handling code here:
        oreo();
        o_p.setVisible(false);
    }//GEN-LAST:event_o_sActionPerformed

    private void o_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(o_q.getText());
        ++i;
        o_q.setText(String.valueOf(i));
    }//GEN-LAST:event_o_aActionPerformed

    private void o_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(o_q.getText());
        --i;
        o_q.setText(String.valueOf(i));
    }//GEN-LAST:event_o_mActionPerformed

    private void nh_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nh_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Nutella Hazelnut"; // 
        String size = (String) nh_s.getSelectedItem();

        double price1 = Double.parseDouble(nh_p.getText());
        int quantity = Integer.parseInt(nh_q.getText());

        nh_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        nh_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        nh_q.setText("0");
        nh_t.setVisible(false);
        txt();
    }//GEN-LAST:event_nh_addActionPerformed

    private void nh_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nh_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nh_q.getText());
        ++i;
        nh_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nh_aActionPerformed

    private void nh_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nh_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nh_q.getText());
        --i;
        nh_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nh_mActionPerformed

    private void nh_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nh_sActionPerformed
        // TODO add your handling code here:
        nutellahazel();
        nh_p.setVisible(false);
    }//GEN-LAST:event_nh_sActionPerformed

    private void rv_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rv_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Red Velvet"; // 
        String size = (String) rv_s.getSelectedItem();

        double price1 = Double.parseDouble(rv_p.getText());
        int quantity = Integer.parseInt(rv_q.getText());

        rv_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        rv_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        rv_q.setText("0");
        rv_t.setVisible(false);
        txt();
    }//GEN-LAST:event_rv_addActionPerformed

    private void rv_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rv_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(rv_q.getText());
        ++i;
        rv_q.setText(String.valueOf(i));
    }//GEN-LAST:event_rv_aActionPerformed

    private void rv_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rv_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(rv_q.getText());
        --i;
        rv_q.setText(String.valueOf(i));
    }//GEN-LAST:event_rv_mActionPerformed

    private void rv_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rv_sActionPerformed
        // TODO add your handling code here:
        redvelvet();
        rv_p.setVisible(false);
    }//GEN-LAST:event_rv_sActionPerformed

    private void clo_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clo_sActionPerformed
        // TODO add your handling code here:
        chocoloco();
        cl_p.setVisible(false);
    }//GEN-LAST:event_clo_sActionPerformed

    private void cl_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(cl_q.getText());
        ++i;
        cl_q.setText(String.valueOf(i));
    }//GEN-LAST:event_cl_aActionPerformed

    private void cl_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cl_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(cl_q.getText());
        --i;
        cl_q.setText(String.valueOf(i));
    }//GEN-LAST:event_cl_mActionPerformed

    private void on_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Oreo Nutella"; // 
        String size = (String) on_s.getSelectedItem();

        double price1 = Double.parseDouble(on_p.getText());
        int quantity = Integer.parseInt(on_q.getText());

        on_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        on_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        on_q.setText("0");
        on_t.setVisible(false);
        txt();
    }//GEN-LAST:event_on_addActionPerformed

    private void on_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(on_q.getText());
        ++i;
        on_q.setText(String.valueOf(i));
    }//GEN-LAST:event_on_aActionPerformed

    private void on_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(on_q.getText());
        --i;
        on_q.setText(String.valueOf(i));
    }//GEN-LAST:event_on_mActionPerformed

    private void on_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_on_sActionPerformed
        // TODO add your handling code here:
        oreonutella();
        on_p.setVisible(false);
    }//GEN-LAST:event_on_sActionPerformed

    private void nv_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nv_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Nutella Velvet"; // 
        String size = (String) nv_s.getSelectedItem();

        double price1 = Double.parseDouble(nv_p.getText());
        int quantity = Integer.parseInt(nv_q.getText());

        nv_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        nv_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        nv_q.setText("0");
        nv_t.setVisible(false);
        txt();
    }//GEN-LAST:event_nv_addActionPerformed

    private void nv_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nv_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nv_q.getText());
        ++i;
        nv_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nv_aActionPerformed

    private void nv_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nv_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nv_q.getText());
        --i;
        nv_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nv_mActionPerformed

    private void nv_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nv_sActionPerformed
        // TODO add your handling code here:
        nutellavelvet();
        nv_p.setVisible(false);
    }//GEN-LAST:event_nv_sActionPerformed

    private void cn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cn_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Choco Nuttela"; // 
        String size = (String) nv_s.getSelectedItem();

        double price1 = Double.parseDouble(nv_p.getText());
        int quantity = Integer.parseInt(nv_q.getText());

        nv_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        nv_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        nv_q.setText("0");
        nv_t.setVisible(false);
        txt();
    }//GEN-LAST:event_cn_addActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Savepurchase s = new Savepurchase();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cn_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cn_aActionPerformed
        int i = Integer.valueOf(cn_q.getText());
        ++i;
        cn_q.setText(String.valueOf(i));
    }//GEN-LAST:event_cn_aActionPerformed

    private void nb_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nb_sActionPerformed
        // TODO add your handling code here:
        nutellaberry();
        nb_p.setVisible(false);
    }//GEN-LAST:event_nb_sActionPerformed

    private void nb_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nb_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Nuteella Berry"; // 
        String size = (String) nb_s.getSelectedItem();

        double price1 = Double.parseDouble(nb_p.getText());
        int quantity = Integer.parseInt(nb_q.getText());

        nb_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        nb_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        nb_q.setText("0");
        nb_t.setVisible(false);
        txt();
    }//GEN-LAST:event_nb_addActionPerformed

    private void nb_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nb_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nb_q.getText());
        ++i;
        nb_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nb_aActionPerformed

    private void nb_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nb_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(nb_q.getText());
        --i;
        nb_q.setText(String.valueOf(i));
    }//GEN-LAST:event_nb_mActionPerformed

    private void cn_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cn_sActionPerformed
        // TODO add your handling code here:
        choconutella();
        cn_p.setVisible(false);
    }//GEN-LAST:event_cn_sActionPerformed

    private void ga2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga2_sActionPerformed
        // TODO add your handling code here:
        fgreenapple();
        ga_p.setVisible(false);
    }//GEN-LAST:event_ga2_sActionPerformed

    private void ga_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Green Apple"; // 
        String size = (String) ga2_s.getSelectedItem();

        double price1 = Double.parseDouble(ga_p.getText());
        int quantity = Integer.parseInt(ga_q.getText());

        ga2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ga_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ga_q.setText("0");
        ga_t.setVisible(false);
        txt();
    }//GEN-LAST:event_ga_addActionPerformed

    private void ga_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ga_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ga_q.getText());
        --i;
        ga_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ga_mActionPerformed

    private void s_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Strawberry"; // 
        String size = (String) s2_s.getSelectedItem();

        double price1 = Double.parseDouble(s_p.getText());
        int quantity = Integer.parseInt(s_q.getText());

        s2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        s_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        s_q.setText("0");
        s_t.setVisible(false);
        txt();
    }//GEN-LAST:event_s_addActionPerformed

    private void s_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(s_q.getText());
        ++i;
        s_q.setText(String.valueOf(i));
    }//GEN-LAST:event_s_aActionPerformed

    private void s_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(s_q.getText());
        --i;
        s_q.setText(String.valueOf(i));
    }//GEN-LAST:event_s_mActionPerformed

    private void pf_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pf_q.getText());
        ++i;
        pf_q.setText(String.valueOf(i));
    }//GEN-LAST:event_pf_aActionPerformed

    private void s2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2_sActionPerformed
        // TODO add your handling code here:
        fstrawberry();
        s_p.setVisible(false);
    }//GEN-LAST:event_s2_sActionPerformed

    private void pf_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Passion Fruit"; // 
        String size = (String) p2_s.getSelectedItem();

        double price1 = Double.parseDouble(pf_p.getText());
        int quantity = Integer.parseInt(pf_q.getText());

        p2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        pf_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        pf_q.setText("0");
        pf_t.setVisible(false);
        txt();
    }//GEN-LAST:event_pf_addActionPerformed

    private void p2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2_sActionPerformed
        // TODO add your handling code here:

        fpassion();
        pf_p.setVisible(false);
    }//GEN-LAST:event_p2_sActionPerformed

    private void pf_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(pf_q.getText());
        --i;
        pf_q.setText(String.valueOf(i));
    }//GEN-LAST:event_pf_mActionPerformed

    private void l_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Lychee"; // 
        String size = (String) l2_s.getSelectedItem();

        String priceText = l_p.getText();
        double price1 = 0.0;
        if (!priceText.isEmpty()) {
            price1 = Double.parseDouble(priceText);
        }
        String quantityText = l_q.getText();
        int quantity = 0; // Default value in case of empty string
        if (!quantityText.isEmpty()) {
            quantity = Integer.parseInt(quantityText);
        }
        l2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        l_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        l_q.setText("0");
        l_t.setVisible(false);
        txt();
    }//GEN-LAST:event_l_addActionPerformed

    private void l_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(l_q.getText());
        ++i;
        l_q.setText(String.valueOf(i));
    }//GEN-LAST:event_l_aActionPerformed

    private void l_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(l_q.getText());
        --i;
        l_q.setText(String.valueOf(i));
    }//GEN-LAST:event_l_mActionPerformed

    private void l2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2_sActionPerformed
        // TODO add your handling code here:
        flemon();
        l_p.setVisible(false);
    }//GEN-LAST:event_l2_sActionPerformed

    private void ln2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln2_sActionPerformed
        // TODO add your handling code here:
        flemon();
        ln_p.setVisible(false);
    }//GEN-LAST:event_ln2_sActionPerformed

    private void ln_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln_addActionPerformed
        // TODO add your handling code here:
        String product_Name = "Tea Lemon"; // 
        String size = (String) ln2_s.getSelectedItem();

        double price1 = Double.parseDouble(ln_p.getText());
        int quantity = Integer.parseInt(ln_q.getText());

        ln2_s.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        ln_t.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_Name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_Name, size, price1, quantity, totalprice});
        }

        ln_q.setText("0");
        ln_t.setVisible(false);
        txt();
    }//GEN-LAST:event_ln_addActionPerformed

    private void ln_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ln_q.getText());
        ++i;
        ln_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ln_aActionPerformed

    private void ln_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ln_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(ln_q.getText());
        --i;
        ln_q.setText(String.valueOf(i));
    }//GEN-LAST:event_ln_mActionPerformed

    private void b_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(b_q.getText());
        ++i;
        b_q.setText(String.valueOf(i));
    }//GEN-LAST:event_b_aActionPerformed

    private void b2_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_sActionPerformed
        // TODO add your handling code here:
        fblueberry();
        b_p.setVisible(false);
    }//GEN-LAST:event_b2_sActionPerformed

    private void sinker_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinker_iActionPerformed
        // TODO add your handling code here:
        sinkers();
        sinkers_p.setVisible(false);
    }//GEN-LAST:event_sinker_iActionPerformed

    private void sinkers_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinkers_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(sinkers_q.getText());
        --i;
        sinkers_q.setText(String.valueOf(i));
    }//GEN-LAST:event_sinkers_mActionPerformed

    private void topp_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topp_addActionPerformed
        // TODO add your handling code here:
        String product_name = (String) topp_i.getSelectedItem();
        String size = "-------"; // 
        double price1 = Double.parseDouble(topp_p.getText());
        int quantity = Integer.parseInt(topp_q.getText());

        topp_i.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        topp_p.setText(String.valueOf((totalprice)));

        topp_i.setSelectedIndex(1);

        topp_p.setText(String.valueOf(totalprice));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_name, size, price1, quantity, totalprice});
        }

        topp_q.setText("0");
        topp_t.setVisible(false);
        txt();
    }//GEN-LAST:event_topp_addActionPerformed

    private void topp_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topp_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(topp_q.getText());
        ++i;
        topp_q.setText(String.valueOf(i));
    }//GEN-LAST:event_topp_aActionPerformed

    private void topp_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topp_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(topp_q.getText());
        --i;
        topp_q.setText(String.valueOf(i));
    }//GEN-LAST:event_topp_mActionPerformed

    private void topp_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topp_iActionPerformed
        // TODO add your handling code here:
        topp();
        topp_p.setVisible(false);
    }//GEN-LAST:event_topp_iActionPerformed

    private void add_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_addActionPerformed
        // TODO add your handling code here:
        String product_name = (String) add_i.getSelectedItem();
        String size = "-------"; // 
        double price1 = Double.parseDouble(add_p.getText());
        int quantity = Integer.parseInt(add_q.getText());

        add_i.setSelectedIndex(1);

        double totalprice = price1 * quantity;
        add_p.setText(String.valueOf((totalprice)));

        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        boolean rowExists = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 0);
            String rowSize = (String) model.getValueAt(i, 1);
            if (productName.equals(product_name) && rowSize.equals(size)) {
                int existingQuantity = (int) model.getValueAt(i, 3);
                double existingTotalPrice = (double) model.getValueAt(i, 4);

                int newQuantity = existingQuantity + quantity;
                double newTotalPrice = existingTotalPrice + totalprice;

                model.setValueAt(newQuantity, i, 3);
                model.setValueAt(newTotalPrice, i, 4);

                rowExists = true;
                break;
            }
        }

        if (!rowExists) {
            model.addRow(new Object[]{product_name, size, price1, quantity, totalprice});
        }

        add_q.setText("0");
        add_t.setVisible(false);
        txt();
    }//GEN-LAST:event_add_addActionPerformed

    private void add_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_aActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(add_q.getText());
        ++i;
        add_q.setText(String.valueOf(i));
    }//GEN-LAST:event_add_aActionPerformed

    private void add_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_mActionPerformed
        // TODO add your handling code here:
        int i = Integer.valueOf(add_q.getText());
        --i;
        add_q.setText(String.valueOf(i));
    }//GEN-LAST:event_add_mActionPerformed

    private void add_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_iActionPerformed
        // TODO add your handling code here:
        add();
        add_p.setVisible(false);
    }//GEN-LAST:event_add_iActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            txtbill.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean e = false;

        System.out.println(e);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtbill.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        login s = new login();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        int selectedRowIndex = ORDERS_TABLE.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = ORDERS_TABLE.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
            model.removeRow(selectedRow);
            txt();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void UPDATE_TABLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_TABLEActionPerformed
        DefaultTableModel model = (DefaultTableModel) ORDERS_TABLE.getModel();
        int selectedRowIndex = ORDERS_TABLE.getSelectedRow();

        String product_name = ORDERS_TABLE.getValueAt(selectedRowIndex, 0).toString();
        String product_size = ORDERS_TABLE.getValueAt(selectedRowIndex, 1).toString();
        String product_price = ORDERS_TABLE.getValueAt(selectedRowIndex, 2).toString();
        String product_quantity = ORDERS_TABLE.getValueAt(selectedRowIndex, 3).toString();
        String product_total = ORDERS_TABLE.getValueAt(selectedRowIndex, 4).toString();

        updateModal.setDetails(selectedRowIndex, product_name, product_size, product_price, product_quantity, product_total);
        updateModal.setMainFrame(this); // Pass the reference to the ORDERS frame
        updateModal.setVisible(true);

        txt();
    }//GEN-LAST:event_UPDATE_TABLEActionPerformed

    private void cn_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cn_mActionPerformed
        int i = Integer.valueOf(cn_q.getText());
        --i;
        cn_q.setText(String.valueOf(i));
    }//GEN-LAST:event_cn_mActionPerformed

    public void updateMainTable(int selectedRowIndex, String productName, String size, double price, int quantity, double total) {
        DefaultTableModel mainTableModel = (DefaultTableModel) ORDERS_TABLE.getModel();
        mainTableModel.setValueAt(productName, selectedRowIndex, 0);
        mainTableModel.setValueAt(size, selectedRowIndex, 1);
        mainTableModel.setValueAt(price, selectedRowIndex, 2);
        mainTableModel.setValueAt(quantity, selectedRowIndex, 3);
        mainTableModel.setValueAt(total, selectedRowIndex, 4);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ORDERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ORDERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ORDERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ORDERS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ORDERS().setVisible(true);
            }
        });
    }

    // ...

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ORDERS_TABLE;
    private javax.swing.JButton UPDATE_TABLE;
    private javax.swing.JButton add_a;
    private javax.swing.JButton add_add;
    private javax.swing.JComboBox add_i;
    private javax.swing.JButton add_m;
    private javax.swing.JLabel add_p;
    private javax.swing.JLabel add_q;
    private javax.swing.JLabel add_t;
    private javax.swing.JPanel addtional_p;
    private javax.swing.JLabel b1_q;
    private javax.swing.JComboBox b1_s;
    private javax.swing.JComboBox b2_s;
    private javax.swing.JButton b_a;
    private javax.swing.JButton b_add;
    private javax.swing.JButton b_m;
    private javax.swing.JLabel b_p;
    private javax.swing.JLabel b_q;
    private javax.swing.JLabel b_t;
    private javax.swing.JButton bb1_a;
    private javax.swing.JButton bb1_add;
    private javax.swing.JButton bb1_m;
    private javax.swing.JLabel bb1_p;
    private javax.swing.JLabel bb1_t;
    private javax.swing.JButton bsu_a;
    private javax.swing.JButton bsu_add;
    private javax.swing.JButton bsu_m;
    private javax.swing.JLabel bsu_p;
    private javax.swing.JLabel bsu_q;
    private javax.swing.JComboBox bsu_s;
    private javax.swing.JLabel bsu_t;
    private javax.swing.JButton c_a;
    private javax.swing.JButton c_add;
    private javax.swing.JButton c_m;
    private javax.swing.JLabel c_p;
    private javax.swing.JLabel c_q;
    private javax.swing.JLabel c_t;
    private javax.swing.JButton cb_add;
    private javax.swing.JComboBox cb_s;
    private javax.swing.JButton ch_add;
    private javax.swing.JLabel ch_t;
    private javax.swing.JButton cheese_a;
    private javax.swing.JButton cheese_m;
    private javax.swing.JLabel cheese_p;
    private javax.swing.JLabel cheese_q;
    private javax.swing.JComboBox cheese_s;
    private javax.swing.JLabel cheese_t;
    private javax.swing.JPanel cheesecake_p;
    private javax.swing.JButton chicken_a;
    private javax.swing.JLabel chicken_hawaiin;
    private javax.swing.JButton chicken_m;
    private javax.swing.JLabel chicken_p;
    private javax.swing.JLabel chicken_q;
    private javax.swing.JComboBox chicken_s;
    private javax.swing.JButton cl_a;
    private javax.swing.JButton cl_add;
    private javax.swing.JButton cl_m;
    private javax.swing.JLabel cl_p;
    private javax.swing.JLabel cl_q;
    private javax.swing.JLabel cl_t;
    private javax.swing.JComboBox clo_s;
    private javax.swing.JButton cn_a;
    private javax.swing.JButton cn_add;
    private javax.swing.JButton cn_m;
    private javax.swing.JLabel cn_p;
    private javax.swing.JLabel cn_q;
    private javax.swing.JComboBox cn_s;
    private javax.swing.JLabel cn_t;
    private javax.swing.JButton dc_a;
    private javax.swing.JButton dc_add;
    private javax.swing.JButton dc_m;
    private javax.swing.JLabel dc_p;
    private javax.swing.JLabel dc_q;
    private javax.swing.JComboBox dc_s;
    private javax.swing.JLabel dc_t;
    private javax.swing.JButton dcc_a;
    private javax.swing.JButton dcc_add;
    private javax.swing.JButton dcc_m;
    private javax.swing.JLabel dcc_p;
    private javax.swing.JLabel dcc_q;
    private javax.swing.JComboBox dcc_s;
    private javax.swing.JLabel dcc_t;
    private javax.swing.JButton delete;
    private javax.swing.JPanel fruit_p;
    private javax.swing.JButton ga1_a;
    private javax.swing.JButton ga1_add;
    private javax.swing.JButton ga1_m;
    private javax.swing.JLabel ga1_p;
    private javax.swing.JLabel ga1_q;
    private javax.swing.JComboBox ga1_s;
    private javax.swing.JPanel ga1_t;
    private javax.swing.JComboBox ga2_s;
    private javax.swing.JLabel ga_T;
    private javax.swing.JButton ga_a;
    private javax.swing.JButton ga_add;
    private javax.swing.JButton ga_m;
    private javax.swing.JLabel ga_p;
    private javax.swing.JLabel ga_q;
    private javax.swing.JLabel ga_t;
    private javax.swing.JPanel house_p;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton l1_a;
    private javax.swing.JButton l1_add;
    private javax.swing.JButton l1_m;
    private javax.swing.JLabel l1_p;
    private javax.swing.JLabel l1_q;
    private javax.swing.JComboBox l1_s;
    private javax.swing.JLabel l1_t;
    private javax.swing.JComboBox l2_s;
    private javax.swing.JButton l_a;
    private javax.swing.JButton l_add;
    private javax.swing.JButton l_m;
    private javax.swing.JLabel l_p;
    private javax.swing.JLabel l_q;
    private javax.swing.JLabel l_t;
    private javax.swing.JButton ln1_a;
    private javax.swing.JButton ln1_add;
    private javax.swing.JButton ln1_m;
    private javax.swing.JLabel ln1_p;
    private javax.swing.JLabel ln1_q;
    private javax.swing.JComboBox ln1_s;
    private javax.swing.JLabel ln1_t;
    private javax.swing.JComboBox ln2_s;
    private javax.swing.JButton ln_a;
    private javax.swing.JButton ln_add;
    private javax.swing.JButton ln_m;
    private javax.swing.JLabel ln_p;
    private javax.swing.JLabel ln_q;
    private javax.swing.JLabel ln_t;
    private javax.swing.JButton ms_a;
    private javax.swing.JButton ms_m;
    private javax.swing.JLabel ms_p;
    private javax.swing.JLabel ms_q;
    private javax.swing.JComboBox ms_s;
    private javax.swing.JLabel ms_t;
    private javax.swing.JButton nb_a;
    private javax.swing.JButton nb_add;
    private javax.swing.JButton nb_m;
    private javax.swing.JLabel nb_p;
    private javax.swing.JLabel nb_q;
    private javax.swing.JComboBox nb_s;
    private javax.swing.JLabel nb_t;
    private javax.swing.JButton nh_a;
    private javax.swing.JButton nh_add;
    private javax.swing.JButton nh_m;
    private javax.swing.JLabel nh_p;
    private javax.swing.JLabel nh_q;
    private javax.swing.JComboBox nh_s;
    private javax.swing.JLabel nh_t;
    private javax.swing.JButton ns_a;
    private javax.swing.JButton ns_add;
    private javax.swing.JButton ns_m;
    private javax.swing.JLabel ns_p;
    private javax.swing.JLabel ns_q;
    private javax.swing.JComboBox ns_s;
    private javax.swing.JLabel ns_t;
    private javax.swing.JPanel nuttela_p;
    private javax.swing.JButton nv_a;
    private javax.swing.JButton nv_add;
    private javax.swing.JButton nv_m;
    private javax.swing.JLabel nv_p;
    private javax.swing.JLabel nv_q;
    private javax.swing.JComboBox nv_s;
    private javax.swing.JLabel nv_t;
    private javax.swing.JButton o_a;
    private javax.swing.JButton o_add;
    private javax.swing.JButton o_m;
    private javax.swing.JLabel o_p;
    private javax.swing.JLabel o_q;
    private javax.swing.JComboBox o_s;
    private javax.swing.JLabel o_t;
    private javax.swing.JButton oc_a;
    private javax.swing.JButton oc_add;
    private javax.swing.JButton oc_m;
    private javax.swing.JLabel oc_p;
    private javax.swing.JLabel oc_q;
    private javax.swing.JComboBox oc_s;
    private javax.swing.JLabel oc_t;
    private javax.swing.JButton occ_a;
    private javax.swing.JButton occ_add;
    private javax.swing.JButton occ_m;
    private javax.swing.JLabel occ_p;
    private javax.swing.JLabel occ_q;
    private javax.swing.JComboBox occ_s;
    private javax.swing.JLabel occ_t;
    private javax.swing.JButton on_a;
    private javax.swing.JButton on_add;
    private javax.swing.JButton on_m;
    private javax.swing.JLabel on_p;
    private javax.swing.JLabel on_q;
    private javax.swing.JComboBox on_s;
    private javax.swing.JLabel on_t;
    private javax.swing.JButton oo_a;
    private javax.swing.JButton oo_add;
    private javax.swing.JButton oo_m;
    private javax.swing.JLabel oo_p;
    private javax.swing.JLabel oo_q;
    private javax.swing.JComboBox oo_s;
    private javax.swing.JLabel oo_t;
    private javax.swing.JComboBox p2_s;
    private javax.swing.JButton p_add;
    private javax.swing.JLabel p_t;
    private javax.swing.JButton payment_b;
    private javax.swing.JLabel pepperoni;
    private javax.swing.JButton pepperoni_a;
    private javax.swing.JButton pepperoni_m;
    private javax.swing.JLabel pepperoni_p;
    private javax.swing.JLabel pepperoni_q;
    private javax.swing.JComboBox pepperoni_s;
    private javax.swing.JButton pf1_a;
    private javax.swing.JButton pf1_add;
    private javax.swing.JButton pf1_m;
    private javax.swing.JLabel pf1_p;
    private javax.swing.JLabel pf1_q;
    private javax.swing.JLabel pf1_t;
    private javax.swing.JButton pf_a;
    private javax.swing.JButton pf_add;
    private javax.swing.JButton pf_m;
    private javax.swing.JLabel pf_p;
    private javax.swing.JLabel pf_q;
    private javax.swing.JLabel pf_t;
    private javax.swing.JPanel pizza_p;
    private javax.swing.JPanel premium_p;
    private javax.swing.JLabel product_c;
    private javax.swing.JComboBox ps1_s;
    private javax.swing.JButton rv_a;
    private javax.swing.JButton rv_add;
    private javax.swing.JButton rv_m;
    private javax.swing.JLabel rv_p;
    private javax.swing.JLabel rv_q;
    private javax.swing.JComboBox rv_s;
    private javax.swing.JLabel rv_t;
    private javax.swing.JButton s1_a;
    private javax.swing.JButton s1_add;
    private javax.swing.JButton s1_m;
    private javax.swing.JLabel s1_p;
    private javax.swing.JLabel s1_q;
    private javax.swing.JComboBox s1_s;
    private javax.swing.JLabel s1_t;
    private javax.swing.JComboBox s2_s;
    private javax.swing.JButton s_a;
    private javax.swing.JButton s_add;
    private javax.swing.JButton s_m;
    private javax.swing.JLabel s_p;
    private javax.swing.JLabel s_q;
    private javax.swing.JLabel s_t;
    private javax.swing.JButton sc1_a;
    private javax.swing.JButton sc1_add;
    private javax.swing.JButton sc1_m;
    private javax.swing.JLabel sc1_p;
    private javax.swing.JLabel sc1_q;
    private javax.swing.JLabel sc1_t;
    private javax.swing.JButton sc_a;
    private javax.swing.JButton sc_add;
    private javax.swing.JButton sc_m;
    private javax.swing.JLabel sc_p;
    private javax.swing.JLabel sc_q;
    private javax.swing.JComboBox scaramel_s;
    private javax.swing.JComboBox sinker_i;
    private javax.swing.JButton sinkers_a;
    private javax.swing.JButton sinkers_add;
    private javax.swing.JButton sinkers_m;
    private javax.swing.JLabel sinkers_p;
    private javax.swing.JLabel sinkers_q;
    private javax.swing.JLabel sinkers_t;
    private javax.swing.JLabel super_p;
    private javax.swing.JComboBox super_s;
    private javax.swing.JLabel super_t;
    private javax.swing.JLabel t;
    private javax.swing.JButton topp_a;
    private javax.swing.JButton topp_add;
    private javax.swing.JComboBox topp_i;
    private javax.swing.JButton topp_m;
    private javax.swing.JLabel topp_p;
    private javax.swing.JLabel topp_q;
    private javax.swing.JLabel topp_t;
    private javax.swing.JLabel txtbal;
    private javax.swing.JTextArea txtbill;
    private javax.swing.JTextField txtpay;
    private javax.swing.JLabel txttotal;
    private javax.swing.JLabel v_t;
    private javax.swing.JButton veggies_a;
    private javax.swing.JButton veggies_add;
    private javax.swing.JButton veggies_m;
    private javax.swing.JLabel veggies_p;
    private javax.swing.JLabel veggies_q;
    private javax.swing.JComboBox veggies_s;
    private javax.swing.JButton wm_a;
    private javax.swing.JButton wm_add;
    private javax.swing.JButton wm_m;
    private javax.swing.JLabel wm_p;
    private javax.swing.JLabel wm_q;
    private javax.swing.JComboBox wm_s;
    private javax.swing.JLabel wm_t;
    // End of variables declaration//GEN-END:variables

    private double getPriceForSize(String selectedSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
