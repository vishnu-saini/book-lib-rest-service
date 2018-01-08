/*
 * 
 */
package com.incedo.booklib.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.booklib.constant.ResponseType;
import com.incedo.booklib.requestbean.LoanRequest;
import com.incedo.booklib.responsebean.BookWithIssueCountResponse;
import com.incedo.booklib.responsebean.LoanBookResponse;
import com.incedo.booklib.responsebean.RootResponse;
import com.incedo.booklib.service.LoanService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookResource.
 */
@RestController
@RequestMapping("api/loan")
public class LoanResource {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(LoanResource.class);

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The book service. */
	@Autowired
	private LoanService loanService;

	/**
	 * Issue book.
	 *
	 * @param loanRequest
	 *            the loan request
	 * @return the root response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> issueBook(@Valid @RequestBody LoanRequest loanRequest) throws Exception {
		logger.info(loanRequest.toString());
		if (loanService.issueBook(loanRequest.getBookId(), loanRequest.getStudentId())) {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("success.loan.issue", null, Locale.US));
		} else {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("error.loan.book.not_able_to_issue", null, Locale.US));
		}
	}

	/**
	 * Deposit book.
	 *
	 * @param loanRequest
	 *            the loan request
	 * @return the root response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> depositBook(@Valid @RequestBody LoanRequest loanRequest) throws Exception {
		logger.info(loanRequest.toString());
		if (loanService.depositBook(loanRequest.getBookId(), loanRequest.getStudentId())) {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("success.loan.deposit", null, Locale.US));
		} else {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("error.loan.book.not_issued", null, Locale.US));
		}

	}

	/**
	 * Gets the issued book of student.
	 *
	 * @param studentId
	 *            the student id
	 * @return the issued book of student
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<LoanBookResponse>> getIssuedBookOfStudent(@RequestParam int studentId) throws Exception {
		return new RootResponse<List<LoanBookResponse>>(ResponseType.SUCCESS,
				loanService.getIssuedBookOfStudent(studentId));
	}

	/**
	 * Test.
	 *
	 * @return the root response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<BookWithIssueCountResponse>> test() throws Exception {
		loanService.test();
		return null;
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setHeader("Content-Disposition", "attachment; filename=\"testExcel.xlsx\"");
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

		ServletOutputStream outputStream = response.getOutputStream();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");

		Object[][] bookData = { { "Head First Java", "Kathy Serria", 79 }, { "Effective Java", "Joshua Bloch", 36 },
				{ "Clean Code", "Robert martin", 42 }, { "Thinking in Java", "Bruce Eckel", 35 }, };

		String[] reportColumns = { "ISBN", "Book Name", "Edision", "Author", "Publisher Name", "Genre", "Assigned To",
				"Date Of Issue" };

		XSSFCellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(51, 153, 255)));
		headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		int rowCount = 0;
		int columnCount = 0;
		Row row = sheet.createRow(rowCount++);

		for (String string : reportColumns) {
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(string);
			cell.setCellStyle(headerCellStyle);
		}

		for (Object[] aBook : bookData) {

			row = sheet.createRow(rowCount++);

			columnCount = 0;

			for (Object field : aBook) {
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
				cellStyle.setFillPattern(CellStyle.ALIGN_FILL);

				Cell cell = row.createCell(columnCount++);
				cell.setCellStyle(cellStyle);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		sheet.setAutoFilter(CellRangeAddress.valueOf("A1:H1"));

		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
