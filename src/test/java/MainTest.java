import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;

public class MainTest {

    Main sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Main();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testTaxEarningsMinusSpendings() {
        // given:
        int earnings = 1000, spendings = 300, expected = 100;
        // when:
        int result = sut.taxEarningsMinusSpendings(earnings, spendings);
        // then:
        assertNotEquals(expected, result);
    }

    @Test
    void testTaxEarningsEquals() {
        // given:
        int earnings = 1000, condition = 60;
        // when:
        int result = sut.taxEarnings(earnings);
        // then:
        assertTrue(condition == result);
    }

    @Test
    public void testDifferenceTaxs() {
        // given:
        int tax1 = 900, tax = 1000, expected = 100;
        // when:
        int result = sut.differenceTaxs(tax1, tax);
        // then:
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("source")
    public void testDifferenceTaxsWithSource(int tax1, int tax, int expected) {
        // when:
        int result = sut.differenceTaxs(tax1, tax);
        // then:
        assertEquals(expected, result);

    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(200, 300, 100), Arguments.of(400, 200, 200)
        );
    }

//    Hamcrest:

    @Test
    void assertEqualsDifferenceTaxs() {
        assertThat(sut.differenceTaxs(900, 1000), is(equalTo(100)));
    }

    @Test
    void assertNotEqualsTaxEarningsMinusSpendings() {
        assertNotEquals(sut.taxEarningsMinusSpendings(1000, 300), 100);
    }

    @Test
    public void taxEarningsMinusSpendings_whenGreaterThanOrEqTo0_thenCorrect() {
        int result = sut.taxEarningsMinusSpendings(1000, 1100);
        assertThat(result, greaterThanOrEqualTo(0));
    }


}

