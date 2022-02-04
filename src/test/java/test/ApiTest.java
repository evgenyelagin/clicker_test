package test;

import models.OwnerPojoModel;
import models.RomeNumber;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.*;

import static utils.APIUtils.*;
import static utils.BodyIsEmpty.*;
import static utils.ConfProperties.*;
import static utils.Constants.*;
import static utils.Converter.*;

public class ApiTest {
    private final String URL = getProperty("URL");


    @Test
    public void testValue1to50() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 1; i <= 50; i++) {
            RomeNumber romeNumberModel = getNumber(URL + i);
            softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
            Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
            softAssert.assertEquals(romanToInt(romeNumberModel.getValue()), i);
        }
        softAssert.assertAll();
    }

    @Test
    public void testValue51() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + FIFTY_ONE);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertEquals(romanToInt(romeNumberModel.getValue()), FIFTY_ONE);
        softAssert.assertAll();
    }

    @Test
    public void testValue1004() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + ONE_ZERO_ZERO_FOUR);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertEquals(romanToInt(romeNumberModel.getValue()), ONE_ZERO_ZERO_FOUR);
        softAssert.assertAll();
    }

    @Test
    public void testValue0() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + ZERO);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertEquals(romanToInt(romeNumberModel.getValue()), ZERO);
        softAssert.assertAll();
    }

    @Test
    public void testNotCorrectValue() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + UN_CORRECT_VALUE);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertAll();
    }

    @Test
    public void testTextToGetRequest() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + TEXT_VALUE);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertAll();
    }

    @Test
    public void testWithALotOfWhitespace() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + WHITESPACE_VALUE);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertAll();
    }

    @Test
    public void testSpecialSymbols() {
        SoftAssert softAssert = new SoftAssert();
        RomeNumber romeNumberModel = getNumber(URL + SPECIAL_SYMBOLS);
        softAssert.assertEquals(romeNumberModel.getCode(), CODE_200);
        Assert.assertTrue(isBodyIsNull(romeNumberModel.getValue()));
        softAssert.assertAll();
    }

    @Test
    public void postOwnerField() {
        OwnerPojoModel ownerPojoModel = new OwnerPojoModel(ANAKIN, SKYWALKER);
        APIUtils.postOwnerFiledRequest(ownerPojoModel);
    }

    @Test
    public void deletePostOwnerField() {
        APIUtils.postDeleteOwnerFiled(getProperty("URL11"));
    }

    @Test
    public void testRomeNumberWithOwnerValue1to50() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 1; i <= 50; i++) {
            RomeNumber romeNumberOwner = getNumberOwner(URL + i);
            softAssert.assertEquals(romeNumberOwner.getCode(), CODE_200);
            Assert.assertTrue(isBodyIsNull(romeNumberOwner.getValue()));
            softAssert.assertEquals(romanToInt(romeNumberOwner.getValue()), i);
            softAssert.assertEquals(romeNumberOwner.getOwner(), ANAKIN_SKYWALKER);
        }
        softAssert.assertAll();
    }

    @Test
    public void testRomeNumberWithOwnerValue51to200() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 51; i <= 200; i++) {
            RomeNumber romeNumberOwner = getNumberOwner(URL + i);
            softAssert.assertEquals(romeNumberOwner.getCode(), CODE_200);
            Assert.assertTrue(isBodyIsNull(romeNumberOwner.getValue()));
            softAssert.assertEquals(romanToInt(romeNumberOwner.getValue()), i);
            softAssert.assertTrue(isBodyIsNull(romeNumberOwner.getOwner()));
            softAssert.assertEquals(romeNumberOwner.getOwner(), ANAKIN_SKYWALKER);
        }
        softAssert.assertAll();
    }
}