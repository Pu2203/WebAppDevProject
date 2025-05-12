package Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;



@WebServlet("/QRCodeGenerate")
public class QRCodeGenerator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get parameters
        String busId = request.getParameter("busId");
        String customerName = request.getParameter("customerName");
        String seatsReserved = request.getParameter("seatsReserved");

        // Build QR content
        String qrContent = "Bus ID: " + busId +
                           "\nCustomer: " + customerName +
                           "\nSeats: " + seatsReserved;

        // Set response type and download header
        response.setContentType("image/png");
        response.setHeader("Content-Disposition", "attachment; filename=\"ticket_qr.png\"");

        try {
            // Generate QR code
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, 200, 200);

            // Write image to output stream
            OutputStream outputStream = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            outputStream.close();

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}