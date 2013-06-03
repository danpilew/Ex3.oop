package clids.ex4.main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import clids.ex4.main.Sjavac;
import java.security.Permission;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author t7639192
 */
public class SjavacTest extends TestCase {

    private static final String TESTS_PATH = "C:\\Users\\T7639496\\Desktop\\ex4_files\\";

    public SjavacTest() {
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }

    @Override
    protected void tearDown() throws Exception {
        System.setSecurityManager(null); // or save and restore original
        super.tearDown();
    }

    @Test
    public void testFile1() {
        testFile(1, 0);
    }

    @Test
    public void testFile2() {
        testFile(2, 0);
    }

    @Test
    public void testFile3() {
        testFile(3, 0);
    }

    @Test
    public void testFile4() {
        testFile(4, 0);
    }

    @Test
    public void testFile5() {
        testFile(5, 1);
    }

    @Test
    public void testFile6() {
        testFile(6, 1);
    }

    @Test
    public void testFile7() {
        testFile(7, 1);
    }

    @Test
    public void testFile8() {
        testFile(8, 1);
    }

    @Test
    public void testFile9() {
        testFile(9, 0);
    }

    @Test
    public void testFile11() {
        testFile(11, 0);
    }

    @Test
    public void testFile12() {
        testFile(12, 0);
    }

    @Test
    public void testFile13() {
        testFile(13, 0);
    }

    @Test
    public void testFile14() {
        testFile(14, 0);
    }

    @Test
    public void testFile15() {
        testFile(15, 0);
    }

    @Test
    public void testFile16() {
        testFile(16, 1);
    }

    @Test
    public void testFile17() {
        testFile(17, 1);
    }

    @Test
    public void testFile18() {
        testFile(18, 1);
    }

    @Test
    public void testFile19() {
        testFile(19, 0);
    }

    @Test
    public void testFile21() {
        testFile(21, 0);
    }

    @Test
    public void testFile22() {
        testFile(22, 0);
    }

    @Test
    public void testFile23() {
        testFile(23, 1);
    }

    @Test
    public void testFile24() {
        testFile(24, 1);
    }

    @Test
    public void testFile25() {
        testFile(25, 1);
    }

    @Test
    public void testFile26() {
        testFile(26, 1);
    }

    @Test
    public void testFile27() {
        testFile(27, 0);
    }

    @Test
    public void testFile28() {
        testFile(28, 0);
    }

    @Test
    public void testFile29() {
        testFile(29, 1);
    }

    @Test
    public void testFile30() {
        testFile(30, 0);
    }

    @Test
    public void testFile31() {
        testFile(31, 0);
    }

    @Test
    public void testFile32() {
        testFile(32, 0);
    }

    @Test
    public void testFile33() {
        testFile(33, 0);
    }

    @Test
    public void testFile34() {
        testFile(34, 0);
    }

    @Test
    public void testFile35() {
        testFile(35, 0);
    }

    @Test
    public void testFile36() {
        testFile(36, 1);
    }

    @Test
    public void testFile37() {
        testFile(37, 1);
    }

    @Test
    public void testFile38() {
        testFile(38, 1);
    }

    @Test
    public void testFile39() {
        testFile(39, 0);
    }

    @Test
    public void testFile41() {
        testFile(41, 0);
    }

    @Test
    public void testFile42() {
        testFile(42, 0);
    }

    @Test
    public void testFile43() {
        testFile(43, 0);
    }

    @Test
    public void testFile44() {
        testFile(44, 1);
    }

    @Test
    public void testFile45() {
        testFile(45, 1);
    }

    @Test
    public void testFile46() {
        testFile(46, 1);
    }

    @Test
    public void testFile47() {
        testFile(47, 1);
    }

    @Test
    public void testFile48() {
        testFile(48, 1);
    }

    @Test
    public void testFile49() {
        testFile(49, 1);
    }

    @Test
    public void testFile50() {
        testFile(50, 0);
    }

    @Test
    public void testFile51() {
        testFile(51, 0);
    }

    @Test
    public void testFile52() {
        testFile(52, 1);
    }

    @Test
    public void testFile53() {
        testFile(53, 1);
    }

    @Test
    public void testFile54() {
        testFile(54, 1);
    }

    @Test
    public void testFile55() {
        testFile(55, 1);
    }

    @Test
    public void testFile56() {
        testFile(56, 0);
    }

    @Test
    public void testFile57() {
        testFile(57, 1);
    }

    @Test
    public void testFile58() {
        testFile(58, 0);
    }

    @Test
    public void testFile59() {
        testFile(59, 0);
    }

    @Test
    public void testFile61() {
        testFile(61, 1);
    }

    @Test
    public void testFile62() {
        testFile(62, 1);
    }

    @Test
    public void testFile63() {
        testFile(63, 1);
    }

    @Test
    public void testFile64() {
        testFile(64, 1);
    }

    @Test
    public void testFile65() {
        testFile(65, 1);
    }

    @Test
    public void testFile66() {
        testFile(66, 1);
    }

    @Test
    public void testFile67() {
        testFile(67, 1);
    }

    @Test
    public void testFile101() {
        testFile(101, 1);
    }

    @Test
    public void testFile102() {
        testFile(102, 1);
    }

    @Test
    public void testFile103() {
        testFile(103, 1);
    }

    @Test
    public void testFile104() {
        testFile(104, 1);
    }

    @Test
    public void testFile105() {
        testFile(105, 1);
    }

    @Test
    public void testFile106() {
        testFile(106, 0);
    }

    @Test
    public void testFile107() {
        testFile(107, 0);
    }

    @Test
    public void testFile108() {
        testFile(108, 0);
    }

    @Test
    public void testFile109() {
        testFile(109, 0);
    }

    @Test
    public void testFile110() {
        testFile(110, 0);
    }

    @Test
    public void testFile111() {
        testFile(111, 0);
    }

    @Test
    public void testFile112() {
        testFile(112, 0);
    }

    @Test
    public void testFile113() {
        testFile(113, 0);
    }

    @Test
    public void testFile114() {
        testFile(114, 1);
    }

    @Test
    public void testFile115() {
        testFile(115, 1);
    }

    @Test
    public void testFile116() {
        testFile(116, 1);
    }

    @Test
    public void testFile117() {
        testFile(117, 1);
    }

    @Test
    public void testFile201() {
        testFile(201, 0);
    }

    @Test
    public void testFile202() {
        testFile(202, 0);
    }

    @Test
    public void testFile203() {
        testFile(203, 0);
    }

    @Test
    public void testFile204() {
        testFile(204, 0);
    }

    @Test
    public void testFile205() {
        testFile(205, 1);
    }

    @Test
    public void testFile206() {
        testFile(206, 1);
    }

    @Test
    public void testFile207() {
        testFile(207, 1);
    }

    @Test
    public void testFile208() {
        testFile(208, 1);
    }

    @Test
    public void testFile209() {
        testFile(209, 0);
    }

    @Test
    public void testFile211() {
        testFile(211, 0);
    }

    @Test
    public void testFile212() {
        testFile(212, 0);
    }

    @Test
    public void testFile213() {
        testFile(213, 0);
    }

    @Test
    public void testFile214() {
        testFile(214, 0);
    }

    @Test
    public void testFile215() {
        testFile(215, 0);
    }

    @Test
    public void testFile216() {
        testFile(216, 1);
    }

    @Test
    public void testFile217() {
        testFile(217, 1);
    }

    @Test
    public void testFile218() {
        testFile(218, 1);
    }

    @Test
    public void testFile219() {
        testFile(219, 0);
    }

    @Test
    public void testFile221() {
        testFile(221, 0);
    }

    @Test
    public void testFile222() {
        testFile(222, 0);
    }

    @Test
    public void testFile223() {
        testFile(223, 1);
    }

    @Test
    public void testFile224() {
        testFile(224, 1);
    }

    @Test
    public void testFile225() {
        testFile(225, 1);
    }

    @Test
    public void testFile226() {
        testFile(226, 1);
    }

    @Test
    public void testFile227() {
        testFile(227, 0);
    }

    @Test
    public void testFile231() {
        testFile(231, 0);
    }

    @Test
    public void testFile232() {
        testFile(232, 0);
    }

    @Test
    public void testFile233() {
        testFile(233, 0);
    }

    @Test
    public void testFile234() {
        testFile(234, 0);
    }

    @Test
    public void testFile235() {
        testFile(235, 0);
    }

    @Test
    public void testFile236() {
        testFile(236, 1);
    }

    @Test
    public void testFile237() {
        testFile(237, 1);
    }

    @Test
    public void testFile238() {
        testFile(238, 1);
    }

    @Test
    public void testFile239() {
        testFile(239, 0);
    }

    @Test
    public void testFile241() {
        testFile(241, 0);
    }

    @Test
    public void testFile242() {
        testFile(242, 0);
    }

    @Test
    public void testFile243() {
        testFile(243, 0);
    }

    @Test
    public void testFile244() {
        testFile(244, 1);
    }

    @Test
    public void testFile245() {
        testFile(245, 1);
    }

    @Test
    public void testFile246() {
        testFile(246, 1);
    }

    @Test
    public void testFile247() {
        testFile(247, 1);
    }

    @Test
    public void testFile248() {
        testFile(248, 1);
    }

    @Test
    public void testFile249() {
        testFile(249, 1);
    }

    @Test
    public void testFile250() {
        testFile(250, 1);
    }

    @Test
    public void testFile251() {
        testFile(251, 0);
    }

    @Test
    public void testFile252() {
        testFile(252, 1);
    }

    @Test
    public void testFile253() {
        testFile(253, 0);
    }

    @Test
    public void testFile254() {
        testFile(254, 1);
    }

    @Test
    public void testFile255() {
        testFile(255, 0);
    }
    //
    //@Test
    //public void testFile256() {
    //    testFile(256, 0);
    //}

    @Test
    public void testFile257() {
        testFile(257, 1);
    }

    @Test
    public void testFile261() {
        testFile(261, 1);
    }

    @Test
    public void testFile262() {
        testFile(262, 1);
    }

    @Test
    public void testFile263() {
        testFile(263, 1);
    }

    @Test
    public void testFile264() {
        testFile(264, 1);
    }

    @Test
    public void testFile265() {
        testFile(265, 1);
    }

    @Test
    public void testFile266() {
        testFile(266, 0);
    }

    @Test
    public void testFile267() {
        testFile(267, 0);
    }

    @Test
    public void testFile268() {
        testFile(268, 1);
    }

    @Test
    public void testFile269() {
        testFile(269, 1);
    }

    @Test
    public void testFile270() {
        testFile(270, 1);
    }

    @Test
    public void testFile271() {
        testFile(271, 0);
    }

    @Test
    public void testFile272() {
        testFile(272, 1);
    }

    @Test
    public void testFile273() {
        testFile(273, 1);
    }

    @Test
    public void testFile274() {
        testFile(274, 1);
    }

    @Test
    public void testFile275() {
        testFile(275, 1);
    }

    @Test
    public void testFile276() {
        testFile(276, 1);
    }

    @Test
    public void testFile277() {
        testFile(277, 1);
    }

    @Test
    public void testFile278() {
        testFile(278, 1);
    }

    @Test
    public void testFile279() {
        testFile(279, 1);
    }

    @Test
    public void testFile280() {
        testFile(280, 0);
    }

    @Test
    public void testFile281() {
        testFile(281, 1);
    }

    @Test
    public void testFile282() {
        testFile(282, 1);
    }

    @Test
    public void testFile283() {
        testFile(283, 1);
    }

    @Test
    public void testFile291() {
        testFile(291, 0);
    }

    @Test
    public void testFile301() {
        testFile(301, 0);
    }

    @Test
    public void testFile302() {
        testFile(302, 0);
    }

    @Test
    public void testFile303() {
        testFile(303, 0);
    }

    @Test
    public void testFile305() {
        testFile(305, 0);
    }

    @Test
    public void testFile306() {
        testFile(306, 1);
    }

    @Test
    public void testFile307() {
        testFile(307, 1);
    }

    @Test
    public void testFile308() {
        testFile(308, 1);
    }

    @Test
    public void testFile309() {
        testFile(309, 1);
    }

    @Test
    public void testFile310() {
        testFile(310, 1);
    }

    @Test
    public void testFile311() {
        testFile(311, 0);
    }

    @Test
    public void testFile312() {
        testFile(312, 0);
    }

    @Test
    public void testFile313() {
        testFile(313, 0);
    }

    @Test
    public void testFile314() {
        testFile(314, 1);
    }

    @Test
    public void testFile315() {
        testFile(315, 0);
    }

    @Test
    public void testFile316() {
        testFile(316, 1);
    }

    @Test
    public void testFile317() {
        testFile(317, 1);
    }

    @Test
    public void testFile318() {
        testFile(318, 1);
    }

    @Test
    public void testFile319() {
        testFile(319, 1);
    }

    @Test
    public void testFile320() {
        testFile(320, 1);
    }

    @Test
    public void testFile321() {
        testFile(321, 0);
    }

    @Test
    public void testFile322() {
        testFile(322, 0);
    }

    @Test
    public void testFile323() {
        testFile(323, 0);
    }

    @Test
    public void testFile324() {
        testFile(324, 0);
    }

    @Test
    public void testFile325() {
        testFile(325, 0);
    }

    @Test
    public void testFile326() {
        testFile(326, 0);
    }

    @Test
    public void testFile327() {
        testFile(327, 0);
    }

    @Test
    public void testFile328() {
        testFile(328, 1);
    }

    @Test
    public void testFile401() {
        testFile(401, 1);
    }

    @Test
    public void testFile402() {
        testFile(402, 1);
    }

    @Test
    public void testFile403() {
        testFile(403, 1);
    }

    @Test
    public void testFile404() {
        testFile(404, 0);
    }

    @Test
    public void testFile405() {
        testFile(405, 0);
    }

    @Test
    public void testFile406() {
        testFile(406, 1);
    }

    @Test
    public void testFile407() {
        testFile(407, 1);
    }

    @Test
    public void testFile408() {
        testFile(408, 1);
    }

    @Test
    public void testFile409() {
        testFile(409, 1);
    }

    @Test
    public void testFile410() {
        testFile(410, 0);
    }

    @Test
    public void testFile411() {
        testFile(411, 0);
    }

    @Test
    public void testFile412() {
        testFile(412, 0);
    }

    @Test
    public void testFile413() {
        testFile(413, 0);
    }

    @Test
    public void testFile414() {
        testFile(414, 0);
    }

    @Test
    public void testFile415() {
        testFile(415, 1);
    }

    @Test
    public void testFile416() {
        testFile(416, 1);
    }

    @Test
    public void testFile417() {
        testFile(417, 1);
    }

    @Test
    public void testFile418() {
        testFile(418, 0);
    }

    @Test
    public void testFile420() {
        testFile(420, 1);
    }

    @Test
    public void testFile421() {
        testFile(421, 1);
    }

    @Test
    public void testFile422() {
        testFile(422, 1);
    }

    @Test
    public void testFile423() {
        testFile(423, 1);
    }

    @Test
    public void testFile425() {
        testFile(425, 0);
    }

    @Test
    public void testFile427() {
        testFile(427, 0);
    }

    @Test
    public void testFile428() {
        testFile(428, 0);
    }

    @Test
    public void testFile429() {
        testFile(429, 1);
    }

    @Test
    public void testFile430() {
        testFile(430, 1);
    }

    @Test
    public void testFile431() {
        testFile(431, 1);
    }

    @Test
    public void testFile432() {
        testFile(432, 0);
    }

    @Test
    public void testFile433() {
        testFile(433, 0);
    }

    @Test
    public void testFile434() {
        testFile(434, 1);
    }

    @Test
    public void testFile435() {
        testFile(435, 1);
    }

    @Test
    public void testFile436() {
        testFile(436, 1);
    }

    @Test
    public void testFile437() {
        testFile(437, 0);
    }

    @Test
    public void testFile438() {
        testFile(438, 0);
    }

    @Test
    public void testFile439() {
        testFile(439, 1);
    }

    @Test
    public void testFile440() {
        testFile(440, 1);
    }

    @Test
    public void testFile441() {
        testFile(441, 1);
    }

    @Test
    public void testFile442() {
        testFile(442, 1);
    }

    @Test
    public void testFile451() {
        testFile(451, 0);
    }

    @Test
    public void testFile452() {
        testFile(452, 1);
    }

    @Test
    public void testFile453() {
        testFile(453, 1);
    }

    @Test
    public void testFile454() {
        testFile(454, 1);
    }

    @Test
    public void testFile455() {
        testFile(455, 1);
    }

    @Test
    public void testFile456() {
        testFile(456, 1);
    }

    @Test
    public void testFile457() {
        testFile(457, 1);
    }

    @Test
    public void testFile458() {
        testFile(458, 1);
    }

    @Test
    public void testFile459() {
        testFile(459, 1);
    }

    @Test
    public void testFile460() {
        testFile(460, 1);
    }

    @Test
    public void testFile461() {
        testFile(461, 0);
    }

    @Test
    public void testFile462() {
        testFile(462, 0);
    }

    @Test
    public void testFile463() {
        testFile(463, 1);
    }

    @Test
    public void testFile464() {
        testFile(464, 1);
    }

    @Test
    public void testFile465() {
        testFile(465, 0);
    }

    @Test
    public void testFile466() {
        testFile(466, 0);
    }

    @Test
    public void testFile467() {
        testFile(467, 1);
    }

    @Test
    public void testFile468() {
        testFile(468, 1);
    }

    @Test
    public void testFile469() {
        testFile(469, 0);
    }

    @Test
    public void testFile470() {
        testFile(470, 1);
    }

    @Test
    public void testFile471() {
        testFile(471, 1);
    }

    @Test
    public void testFile472() {
        testFile(472, 0);
    }

    @Test
    public void testFile473() {
        testFile(473, 0);
    }

    @Test
    public void testFile474() {
        testFile(474, 1);
    }

    @Test
    public void testFile475() {
        testFile(475, 1);
    }

    @Test
    public void testFile476() {
        testFile(476, 1);
    }

    @Test
    public void testFile477() {
        testFile(477, 1);
    }

    @Test
    public void testFile501() {
        testFile(501, 0);
    }

    @Test
    public void testFile502() {
        testFile(502, 1);
    }

    @Test
    public void testFile503() {
        testFile(503, 1);
    }

    @Test
    public void testFile504() {
        testFile(504, 1);
    }

    @Test
    public void testFile505() {
        testFile(505, 0);
    }

    public void testFile(int number, int exitValue) {
        try {
            String fileName = getFilePath(number);
            Sjavac.main(new String[]{fileName});
        } catch (ExitException e) {
            assertEquals("Wrong exit status in file No. " + number, exitValue, e.status);
            //assertEquals("Wrong exit status in file No. " + number, 0, e.status);
        }
    }

//    public static void main(String[] args) throws Exception {
//        SjavacTest test = new SjavacTest();
//        test.setUp();
//        String method = "";
//        for (String file : new File(TESTS_PATH).list()) {
//            //testXXX.sjavac
//            int number = Integer.parseInt(file.substring(4, 7));
//            method += "\n";
//            method += "@Test\n";
//            method += "public void testFile" + number + "() {\n";
//            method += "\ttestFile(" + number + ", " + test.getExitValue(number) + ");\n";
//            method += "}\n";
//        }
//        test.tearDown();
//        System.out.println(method);
//    }
//
//    public int getExitValue(int number) {
//        try {
//            String fileName = getFilePath(number);
//            Sjavac.main(new String[]{fileName});
//            return 0;
//        } catch (ExitException e) {
//            return e.status;
//            //assertEquals("Wrong exit status in file No. " + number, 0, e.status);
//        }
//    }

    public static String getFilePath(int number) {
        String res = TESTS_PATH + "\\test";
        if (number < 10) {
            res += "00";
        } else if (number < 100) {
            res += "0";
        }
        res += number + ".sjava";
        return res;
    }

    protected static class ExitException extends SecurityException {

        public final int status;

        public ExitException(int status) {
            super("There is no escape!");
            this.status = status;
        }
    }

    private static class NoExitSecurityManager extends SecurityManager {

        @Override
        public void checkPermission(Permission perm) {
            // allow anything.
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            // allow anything.
        }

        @Override
        public void checkExit(int status) {
            super.checkExit(status);
            throw new ExitException(status);
        }
    }
}