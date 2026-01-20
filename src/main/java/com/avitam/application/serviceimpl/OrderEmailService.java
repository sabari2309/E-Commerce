package com.avitam.application.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avitam.application.dto.OrderItemDTO;

import java.util.List;

@Service
public class OrderEmailService {

	
    private String apiKey="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";

    public String sendOrderConfirmation(String email,String userName,int orderId,double total,String address,List<OrderItemDTO> items) {
        try {
            String url = "https://api.brevo.com/v3/smtp/email";
            HttpHeaders headers = new HttpHeaders();
            headers.set("api-key", apiKey);   
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            String htmlContent = buildOrderHtml(userName, orderId, total, address, items).replace("\"", "\\\"").replace("\n", "").replace("\r", "");

            String body = """
            {
              "sender": { "name": "Avitam Shopping", "email": "sabareeswarangopal@gmail.com" },
              "to": [{ "email": "%s" }],
              "subject": "Order Confirmed - Order #%d",
              "htmlContent": "%s"
            }
            """.formatted(email, orderId, htmlContent);
            System.out.println(body);
            HttpEntity<String> request = new HttpEntity<>(body, headers);
            System.out.println(request.getBody()+"-"+request.getHeaders());
            RestTemplate rest = new RestTemplate();
            ResponseEntity<String> response =
            	    rest.postForEntity(url, request, String.class);

           System.out.println("STATUS = " + response.getStatusCode());
           System.out.println("BODY = " + response.getBody());

            return "Order email sent to " + email;

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send order email: " + e.getMessage();
        }
    }

    private String buildOrderHtml(String userName,
                                  int orderId,
                                  double total,
                                  String address,
                                  List<OrderItemDTO> items) {

        StringBuilder sb = new StringBuilder();

        sb.append("<h2>Order Confirmed 🎉</h2>");
        sb.append("<p>Hi ").append(userName).append(",</p>");
        sb.append("<p>Your order has been placed successfully.</p>");
        sb.append("<p><b>Order ID:</b> ").append(orderId).append("</p>");

        sb.append("<table border='1' cellpadding='10' cellspacing='0'>");
        sb.append("<tr><th>Product</th><th>Qty</th><th>Price</th></tr>");

        for (OrderItemDTO item : items) {
            sb.append("<tr>");
            sb.append("<td>").append(item.getProductName()).append("</td>");
            sb.append("<td>").append(item.getQuantity()).append("</td>");
            sb.append("<td>₹ ").append(item.getPrice()).append("</td>");
            sb.append("</tr>");
        }

        sb.append("</table>");

        sb.append("<h3>Total: ₹ ").append(total).append("</h3>");
        sb.append("<p><b>Delivery Address:</b><br>").append(address).append("</p>");
        sb.append("<p>Thank you for shopping with us! 😊</p>");

        return sb.toString();
    }
}
