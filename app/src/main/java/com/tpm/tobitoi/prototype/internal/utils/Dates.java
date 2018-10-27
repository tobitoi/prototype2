package com.tpm.tobitoi.prototype.internal.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class Dates {
    private static final SimpleDateFormat ddMMyyyy = new SimpleDateFormat(IConstants.IPatterns.ddMMyyyy, Locale.getDefault());
    private static final DateTimeFormatter ddMMyyyyJoda = DateTimeFormat.forPattern(IConstants.IPatterns.ddMMyyyy);

    /**
     * @return Current day
     */
    public int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return Current month
     */
    public int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * @return Current year
     */
    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * @param calendar Calendar parameter
     * @return Custom range with calendar format
     */
    public String getCustomRange(final Calendar calendar) {
        return ddMMyyyy.format(calendar.getTime());
    }

    /**
     * @return Current date with date format
     */
    public String getCurrentDate() {
        return ddMMyyyy.format(new Date());
    }

    /**
     * @param date Date parameter
     * @return Current week with date format
     */
    public String getCurrentWeek(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfWeek().withMaximumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Current month with date format
     */
    public String getCurrentMonth(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMaximumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Current year with date format
     */
    public String getCurrentYear(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMaximumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Yesterday with date format
     */
    public String getYesterday(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.minusDays(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Start week with date format
     */
    public String getStartWeek(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfWeek().withMinimumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Previous week with date format
     */
    public String getPreviousWeek(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfWeek().withMinimumValue().minusWeeks(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Last week with date format
     */
    public String getLastWeek(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfWeek().withMinimumValue().minusDays(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Start month with date format
     */
    public String getStartMonth(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMinimumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Previous month with date format
     */
    public String getPreviousMonth(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMinimumValue().minusMonths(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Last month with date format
     */
    public String getLastMonth(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMinimumValue().minusDays(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Start year with date format
     */
    public String getStartYear(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMinimumValue();

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Previous year with date format
     */
    public String getPreviousYear(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMinimumValue().minusYears(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @param date Date parameter
     * @return Last year with date format
     */
    public String getLastYear(final Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMinimumValue().minusDays(1);

        return dateTime.toString(ddMMyyyyJoda);
    }

    /**
     * @return Quarter start a Year
     */
    public String getStartQuarter(final Date date) {
        return getQuarterStartFor(date).toString(ddMMyyyyJoda);
    }

    /**
     * @return Quarter end a Year
     */
    public String getEndQuarter(final Date date) {
        return getQuarterEndFor(date).toString(ddMMyyyyJoda);
    }

    private LocalDate getQuarterStartFor(final Date date) {
        LocalDate localDate = new LocalDate(date);
        return localDate.withDayOfMonth(1).withMonthOfYear((((localDate.getMonthOfYear() - 1) / 3) * 3) + 1);
    }

    private LocalDate getQuarterEndFor(final Date date) {
        return getQuarterStartFor(date).plusMonths(3).minusDays(1);
    }
}