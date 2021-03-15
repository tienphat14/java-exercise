package datetimeapi;

import coaching.model.Staff;
import databaseaccess.ConnectionUtil;
import databaseaccess.springjdbctemplate.StaffDao;
import databaseaccess.springjdbctemplate.StaffDaoJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeExample.class);
    private static final String NEW_YORK_ZONE_ID = "America/New_York";

    public static void main(String[] args) throws IOException {
        DateTimeExample example = new DateTimeExample();
//        example.localDate();
//        example.localTime();
//        example.localDateTime();
//        example.zonedDateTime();
//        example.period();
//        example.duration();
//        example.instant();
        example.compareWithLegacy();
    }

    private void localDate() {
        LOGGER.info("********************LocalDate********************");
        LOGGER.info("The current date: {}", LocalDate.now());
        LOGGER.info("4th March 2021: {}", LocalDate.of(2021, Month.MARCH, 4));
        LOGGER.info("Date parse from string: {}", LocalDate.parse("2021-03-04"));
        LOGGER.info("");
        LOGGER.info("Tomorrow: {}", LocalDate.now().plusDays(1));
        LOGGER.info("This day last month: {}", LocalDate.now().minus(1, ChronoUnit.MONTHS));
        LOGGER.info("");
        LOGGER.info("Day of week: {}", LocalDate.now().getDayOfWeek());
        LOGGER.info("Day of month: {}", LocalDate.now().getDayOfMonth());
        LOGGER.info("");
        LOGGER.info("This year is leaf year: {}", LocalDate.now().isLeapYear());
        LOGGER.info("");
        LOGGER.info("Beginning of today: {}", LocalDate.now().atStartOfDay());
        LOGGER.info("First day of this month: {}", LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
        LOGGER.info("");
    }

    private void localTime() {
        LOGGER.info("********************LocalTime********************");
        LOGGER.info("The current time: {}", LocalTime.now());
        LOGGER.info("Six thirty: {}", LocalTime.of(6, 30));
        LOGGER.info("Time from string: {}", LocalTime.parse("06:30"));
        LOGGER.info("");
        LOGGER.info("2 hours from now: {}", LocalTime.now().plusHours(2));
        LOGGER.info("");
        LOGGER.info("Current hour: {}", LocalTime.now().getHour());
        LOGGER.info("Current minute: {}", LocalTime.now().getMinute());
        LOGGER.info("");
        LOGGER.info("Time at min: {}", LocalTime.MIN);
        LOGGER.info("Time at noon: {}", LocalTime.NOON);
        LOGGER.info("Time at midnight: {}", LocalTime.MIDNIGHT);
        LOGGER.info("Time at max: {}", LocalTime.MAX);
        LOGGER.info("");
    }

    private void localDateTime() {
        LOGGER.info("********************LocalDateTime********************");
        LOGGER.info("The current date time: {}", LocalDateTime.now());
        LOGGER.info("4th March 2021 six thirty: {}", LocalDateTime.of(2021, Month.MARCH, 4, 6, 30));
        LOGGER.info("Date time from string: {}", LocalDateTime.parse("2021-03-04T06:30"));
        LOGGER.info("");
        LOGGER.info("next week: {}", LocalDateTime.now().plusWeeks(1));
        LOGGER.info("2 hours before: {}", LocalDateTime.now().minusHours(2));
        LOGGER.info("");
        LOGGER.info("Current month: {}", LocalDateTime.now().getMonth());
        LOGGER.info("");
        LOGGER.info("4th March 2021 six thirty equals 2021-03-04T06:30 is:{}",
                LocalDateTime.of(2021, Month.MARCH, 4, 6, 30)
                        .isEqual(LocalDateTime.parse("2021-03-04T06:30")));
        LOGGER.info("");
    }

    private void zonedDateTime() {
        LOGGER.info("********************ZonedDateTime********************");
        LOGGER.info("All time zone size: {}", ZoneId.getAvailableZoneIds().size());
        LOGGER.info("");
        LOGGER.info("Current time zone: {}", ZoneId.systemDefault());
        LOGGER.info("New York rule: {}", ZoneId.of(NEW_YORK_ZONE_ID).getRules());
        LOGGER.info("GMT-04:00 rule: {}", ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-4)).getRules());
        LOGGER.info("");
        LOGGER.info("Current zoned date time: {}", ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        LOGGER.info("Zoned date time from string: {}", ZonedDateTime.parse("2021-03-04T10:15:30+01:00[Europe/Paris]"));
        LOGGER.info("");
        LOGGER.info("Current new york zoned date time: {}", ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault())
                .withZoneSameInstant(ZoneId.of(NEW_YORK_ZONE_ID)));
        LOGGER.info("");
    }

    private void period() {
        LOGGER.info("********************Period********************");
        LOGGER.info("Five days from now: {}", LocalDate.now().plus(Period.ofDays(5)));
        LOGGER.info("Until next new year: {}", Period.between(LocalDate.now(), LocalDate.ofYearDay(2022, 1)));
        LOGGER.info("");
    }

    private void duration() {
        LOGGER.info("********************Duration********************");
        LOGGER.info("30 seconds from now: {}", LocalDateTime.now().plus(Duration.ofSeconds(30)));
        LOGGER.info("Until tomorrow: {}", Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atStartOfDay()));
        LOGGER.info("");
    }

    private void instant() {
        LOGGER.info("********************Instant********************");
        LOGGER.info("Current date time: {}", LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
        LOGGER.info("Current New York date time: {}", LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.of(NEW_YORK_ZONE_ID)));
        LOGGER.info("");
    }

    private void compareWithLegacy() throws IOException {
        StaffDao staffDao = new StaffDaoJdbcTemplate();
        DateTimeStaffDao dateTimeStaffDao = new DateTimeStaffDao();

        LOGGER.info("********************LegacyCompare********************");
        Calendar calendar = new GregorianCalendar();
        LOGGER.info("Current timezone by calendar {}", calendar.getTimeZone());
        LOGGER.info("Current datetime by calendar {}", calendar.getTime());
        LOGGER.info("Current second by calendar {}", calendar.getTimeInMillis() / 1000);
        dateTimeStaffDao.save(createDateTimeStaff("Current datetime by calendar", calendar.getTime()));
        LOGGER.info("");
        Calendar newYorkCalendar = new GregorianCalendar(TimeZone.getTimeZone(NEW_YORK_ZONE_ID));
        LOGGER.info("Current New York timezone by calendar {}", newYorkCalendar.getTimeZone());
        LOGGER.info("Current New York datetime by calendar {}", newYorkCalendar.getTime());
        LOGGER.info("Current New York second by calendar {}", newYorkCalendar.getTimeInMillis() / 1000);
        dateTimeStaffDao.save(createDateTimeStaff("Current New York datetime by calendar", newYorkCalendar.getTime()));
        LOGGER.info("");
        calendar.setTimeZone(TimeZone.getTimeZone(NEW_YORK_ZONE_ID));
        LOGGER.info("Current New York timezone by switch calendar timezone {}", calendar.getTimeZone());
        LOGGER.info("Current New York datetime by switch calendar timezone {}", calendar.getTime());
        LOGGER.info("Current New York second by switch calendar timezone {}", calendar.getTimeInMillis() / 1000);
        dateTimeStaffDao.save(createDateTimeStaff("Current New York datetime by switch calendar timezone", calendar.getTime()));
        LOGGER.info("");
        long timezoneAlteredTime = calendar.getTimeInMillis() - TimeZone.getDefault().getRawOffset()
                + TimeZone.getTimeZone(NEW_YORK_ZONE_ID).getRawOffset();
        newYorkCalendar.setTimeInMillis(timezoneAlteredTime);
        LOGGER.info("Current New York timezone by alter calendar time {}", newYorkCalendar.getTimeZone());
        LOGGER.info("Current New York datetime by alter calendar time {}", newYorkCalendar.getTime());
        LOGGER.info("Current New York second by alter calendar time {}", newYorkCalendar.getTimeInMillis() / 1000);
        dateTimeStaffDao.save(createDateTimeStaff("Current New York datetime by alter calendar time", newYorkCalendar.getTime()));
        LOGGER.info("");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        LOGGER.info("Current datetime by zoned datetime {}", zonedDateTime);
        LOGGER.info("Current second by zoned datetime {}", zonedDateTime.toEpochSecond());
        staffDao.save(createStaff("Current datetime by zoned datetime", zonedDateTime.toLocalDate()));
        LOGGER.info("");
        ZonedDateTime newYorkZonedDateTime = ZonedDateTime.now(ZoneId.of(NEW_YORK_ZONE_ID));
        LOGGER.info("Current New York datetime by zoned datetime {}", newYorkZonedDateTime);
        LOGGER.info("Current New York second by zoned datetime {}", newYorkZonedDateTime.toEpochSecond());
        staffDao.save(createStaff("Current New York datetime by zoned datetime", newYorkZonedDateTime.toLocalDate()));
        LOGGER.info("");
        ZonedDateTime switchedZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(NEW_YORK_ZONE_ID));
        LOGGER.info("Current New York datetime by switch zoned datetime timezone {}", switchedZonedDateTime);
        LOGGER.info("Current New York second by switch zoned datetime timezone {}", switchedZonedDateTime.toEpochSecond());
        staffDao.save(createStaff("Current New York datetime by switch zoned datetime timezone", switchedZonedDateTime.toLocalDate()));
        LOGGER.info("");
    }

    private Staff createStaff(String firstName, LocalDate dob) {
        Staff staff = new Staff();
        staff.setFirstName(firstName);
        staff.setDob(dob);
        return staff;
    }

    private DateTimeStaff createDateTimeStaff(String firstName, Date dob) {
        DateTimeStaff staff = new DateTimeStaff();
        staff.setFirstName(firstName);
        staff.setDob(dob);
        return staff;
    }

    private class DateTimeStaffDao {
        private JdbcTemplate template;

        public DateTimeStaffDao() throws IOException {
            template = new JdbcTemplate(ConnectionUtil.getMysqlDatasource());
        }

        public int save(DateTimeStaff staff){
            String sql = "insert into basicjava.staff values (null, ?, ?, ?, ?, ?, ?)";
            return template.update(sql,
                    staff.getFirstName(),
                    staff.getMiddleName(),
                    staff.getLastName(),
                    staff.getDob(),
                    staff.getPhone(),
                    staff.getAddress());
        }
    }

    private class DateTimeStaff {
        private Integer id;
        private String firstName;
        private String middleName;
        private String lastName;
        private Date dob;
        private String phone;
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}