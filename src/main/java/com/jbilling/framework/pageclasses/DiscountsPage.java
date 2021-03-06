package com.jbilling.framework.pageclasses;

import com.jbilling.framework.globals.GlobalController;
import com.jbilling.framework.globals.GlobalEnumerations.TextComparators;
import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.interfaces.ElementField;
import com.jbilling.framework.interfaces.LocateBy;
import com.jbilling.framework.utilities.xmlutils.TestData;

public class DiscountsPage {
	// Initialize private logger object
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@LocateBy(xpath = "//div[@class='btn-box']/a/span")
	private ElementField LT_ADDNEW;

	@LocateBy(xpath = "//table[@id='users']/tbody/tr[1]/td/a")
	private ElementField LT_RECENTCUSTOMER;

	@LocateBy(xpath = "//span[text()='Add Sub-Account']")
	private ElementField LT_ALLOWSUBACCOUNT;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//table[@id='discounts']/thead/tr/th/a")
	private ElementField PageHeader_Discounts;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//a[@class='submit add']")
	private ElementField LT_AddNewDiscount;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//table[@id='discounts']/tbody/tr/td/a")
	private ElementField Discounts_AddedDiscount;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//a[@class='submit edit']")
	private ElementField LT_EditDiscount;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//a[@class='submit delete']")
	private ElementField LT_DeleteDiscount;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Confirm']")
	private ElementField Header_DeleteDiscountPopUp;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Yes']")
	private ElementField LT_Yes;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='No']")
	private ElementField LT_No;

	@LocateBy(xpath = "//span[text()='Save Changes']")
	private ElementField LT_SAVECHANGES;

	@LocateBy(xpath = "//input[@id='discount.code']")
	private ElementField TB_DISCOUNTCODE;

	@LocateBy(xpath = "//div[@id='addDescription']/div/select")
	private ElementField DD_ADDDESCRIPTION;

	@LocateBy(xpath = "//div[@id='addDescription']/div/a")
	private ElementField IBT_ADDNEWDESCRIPTION;

	@LocateBy(xpath = "//div[@id='descriptions']/div/div/input")
	private ElementField TB_ADDDESCRIPTION;

	@LocateBy(xpath = "//label[text()='Discount Type']/../select")
	private ElementField DD_DISCOUNTTYPE;

	@LocateBy(xpath = "//input[@id='discount.rate']")
	private ElementField TB_DISCOUNTRATE;

	@LocateBy(xpath = "//table[@id='users']")
	private ElementField TAB_USERS;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//strong[contains(text(),'New Discount')]")
	private ElementField PageHeader_AddNewDiscount;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='discount.code']")
	private ElementField TB_DiscountCode;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//img[@src='/jbilling/static/images/add.png']")
	private ElementField TB_AddDescription;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[contains(@id,'discount.descriptions')]")
	private ElementField TB_DiscountDescription;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//select[@id='discount.type']")
	private ElementField Dropdown_DiscountType;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='discount.rate']")
	private ElementField TB_DiscountRate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='discount.startDate']")
	private ElementField TB_DiscountStartDate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//input[@id='discount.endDate']")
	private ElementField TB_DiscountEndDate;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Save Changes']")
	private ElementField LT_SaveChange;

	@SuppressWarnings("unused")
	@LocateBy(xpath = "//span[text()='Cancel']")
	private ElementField LT_Cancel;

	@LocateBy(xpath = "	//*[@id='jqgh_data_grid_column1_code']")
	private ElementField DISCOUNT_CODE;

	@LocateBy(xpath = "//*[@id='gs_code']")
	private ElementField DISCOUNT_FIELD;

	@LocateBy(xpath = "//*[@id='jqgh_data_grid_column1_description']")
	private ElementField DISCOUNT_DESCRIPTION;

	@LocateBy(xpath = "//*[@id='jqgh_data_grid_column1_type']")
	private ElementField DISCOUNT_TYPE;

	/**
	 * This method will click Add New button
	 */
	public DiscountsPage clickAddNewButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ADDNEW);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will click on recent customer
	 *
	 * @throws Exception
	 */
	public DiscountsPage clickRecentCustomer() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_RECENTCUSTOMER);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will click on Allow Sub Account Button
	 *
	 * @throws Exception
	 */
	public DiscountsPage clickAllowSubAccount() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_ALLOWSUBACCOUNT);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	// /////////////////////////

	/**
	 * This method will set Discount Code
	 *
	 * @throws Exception
	 */
	public DiscountsPage setDiscountCode(String discountCode) throws Exception {
		GlobalController.brw.setText(this.TB_DISCOUNTCODE, discountCode);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will select option in Add Description dropdown
	 *
	 * @throws Exception
	 */
	public DiscountsPage addDescriptionLanguage(String descriptionLanguage) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_ADDDESCRIPTION, descriptionLanguage);
		GlobalController.brw.click(this.IBT_ADDNEWDESCRIPTION);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will set Description
	 *
	 * @throws Exception
	 */
	public DiscountsPage setDescription(String description) throws Exception {
		GlobalController.brw.setText(this.TB_ADDDESCRIPTION, description);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will select option in Discount Type
	 *
	 * @throws Exception
	 */
	public DiscountsPage selectDiscountType(String discountType) throws Exception {
		GlobalController.brw.selectDropDown(this.DD_DISCOUNTTYPE, discountType);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will set Discount Rate
	 *
	 * @throws Exception
	 */
	public DiscountsPage setDiscountRate(String DiscountRate) throws Exception {
		GlobalController.brw.setText(this.TB_DISCOUNTRATE, DiscountRate);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	public DiscountsPage selectcustomer(String user) throws Exception {
		GlobalController.brw.selectTableRowItem(this.TAB_USERS, user);
		return GlobalController.brw.initElements(DiscountsPage.class);

	}

	/**
	 * This method will click Save Changes button
	 */
	public DiscountsPage clickSaveChangesButton() throws Exception {
		GlobalController.brw.clickLinkText(this.LT_SAVECHANGES);
		return GlobalController.brw.initElements(DiscountsPage.class);
	}

	public String createNewDiscount(String testDataSetName, String category) throws Exception {
		DiscountsPage.logger.enterMethod();

		String discountCode = TestData.read("PageDiscounts.xml", testDataSetName, "discountCode", category);
		String descriptionLanguage = TestData.read("PageDiscounts.xml", testDataSetName, "descriptionLanguage", category);
		String description = TestData.read("PageDiscounts.xml", testDataSetName, "description", category);
		String discountType = TestData.read("PageDiscounts.xml", testDataSetName, "discountType", category);
		String discountRate = TestData.read("PageDiscounts.xml", testDataSetName, "discountRate", category);
		String user = TestData.read("PageDiscounts.xml", testDataSetName, "user", category);
		this.setDiscountCode(discountCode);
		this.addDescriptionLanguage(descriptionLanguage);
		this.setDescription(description);
		this.selectDiscountType(discountType);
		this.setDiscountRate(discountRate);
		this.clickSaveChangesButton();

		DiscountsPage.logger.exitMethod();
		return discountCode + " " + "" + "-" + "" + " " + description;
	}

	public DiscountsPage isDiscountCreatedSuccessfully() throws Exception {
		String msg = MessagesPage.isOperationSuccessfulOnMessage("Discount", "created successfully", TextComparators.contains);
		if (msg != null) {
			throw new Exception(msg);
		}

		return GlobalController.brw.initElements(DiscountsPage.class);
	}

	public DiscountsPage isValidationErrorAppeared() throws Exception {
		try {
			MessagesPage.isErrorMessageAppeared();
		} catch (Exception e) {
			throw new Exception("Validation error message field not appeared: " + e.getMessage());
		}

		return GlobalController.brw.initElements(DiscountsPage.class);
	}

	public ConfigurationPage Verifydiscountstable() throws Exception {

		GlobalController.brw.isElementPresent(this.DISCOUNT_CODE);
		GlobalController.brw.isElementPresent(this.DISCOUNT_FIELD);
		GlobalController.brw.isElementPresent(this.DISCOUNT_DESCRIPTION);
		GlobalController.brw.isElementPresent(this.DISCOUNT_TYPE);

		return GlobalController.brw.initElements(ConfigurationPage.class);

	}

}
