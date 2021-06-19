package ge.tsu.transaction.transaction;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import ge.tsu.transaction.user.User;
import java.awt.Color;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.jooq.exception.IOException;

public class TransactionPDFExporter {
  private List<Transaction> transactions;

  public TransactionPDFExporter(
      List<Transaction> transactions) {
    this.transactions = transactions;
  }

  private void writeTableHeader(PdfPTable table) {
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(Color.PINK);
    cell.setPadding(5);

    Font font = FontFactory.getFont(FontFactory.HELVETICA);
    font.setColor(Color.WHITE);

    cell.setPhrase(new Phrase("Document Number", font));

    table.addCell(cell);

    cell.setPhrase(new Phrase("Post Date", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Amount", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Receiver", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Receiver Account", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Sender", font));
    table.addCell(cell);

    cell.setPhrase(new Phrase("Sender Account", font));
    table.addCell(cell);
  }

  private void writeTableData(PdfPTable table) {
    for (Transaction transaction : transactions) {
      table.addCell(transaction.getDocumentNumber());
      table.addCell(transaction.getPostDate().toString());
      table.addCell(transaction.getAmount().toString());
      table.addCell(transaction.getReceiver());
      table.addCell(transaction.getReceiverAccount());
      table.addCell(transaction.getSender());
      table.addCell(transaction.getSenderAccount());
    }
  }

  public void export(HttpServletResponse response)
      throws DocumentException, IOException, java.io.IOException {
    Document document = new Document(PageSize.A2);
    PdfWriter.getInstance(document, response.getOutputStream());

    document.open();
    Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    font.setSize(18);
    font.setColor(Color.DARK_GRAY);


    Paragraph p = new Paragraph("Transactions", font);
    p.setAlignment(Paragraph.ALIGN_CENTER);


    document.add(p);
    document.add(new Paragraph("\n"));

    PdfPTable table = new PdfPTable(7);
    table.setWidthPercentage(100f);
    table.spacingBefore();
    table.setWidths(new float[] {2.5f, 2.5f, 2.0f, 2.5f, 2.5f,1.7f,1.7f});
    table.setSpacingBefore(2);

    writeTableHeader(table);
    writeTableData(table);

    document.add(table);

    document.close();

  }
}
