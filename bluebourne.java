package com.armis.blueborne_detector;

import android.bluetooth.BluetoothDevice;
import android.os.Build.VERSION;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerabilityUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final String DATE_PATTERN = "(\\d{4}-\\d{2}-\\d{2})";
    private static final Date SAFE_DATE = new GregorianCalendar(2017, 8, 1).getTime();
    private static final String SECURITY_PATCH = "ro.build.version.security_patch";

    public static boolean isVulnerable() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        Date securityPatchDate = getSecurityPatchDate();
        if (securityPatchDate == null || securityPatchDate.before(SAFE_DATE)) {
            return true;
        }
        return false;
    }

    public static String getSecurityPatchDateString() {
        if (VERSION.SDK_INT >= 23) {
            return VERSION.SECURITY_PATCH;
        }
        Matcher matcher = Pattern.compile(DATE_PATTERN).matcher(SystemUtils.getSystemProp(SECURITY_PATCH));
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static Date getSecurityPatchDate() {
        Date date = null;
        String securityPatchDate = getSecurityPatchDateString();
        if (securityPatchDate != null) {
            try {
                date = DATE_FORMAT.parse(securityPatchDate);
            } catch (ParseException e) {
            }
        }
        return date;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int calcDeviceRisk(android.bluetooth.BluetoothDevice r7) {
        /*
        r1 = 0;
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r0 = getDeviceOs(r7);
        if (r0 != 0) goto L_0x0019;
    L_0x000a:
        r3 = com.armis.blueborne_detector.Utils.isBle(r7);
        if (r3 == 0) goto L_0x0017;
    L_0x0010:
        r3 = r7.getName();
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        return r1;
    L_0x0017:
        r1 = r2;
        goto L_0x0016;
    L_0x0019:
        r5 = -1;
        r6 = r0.hashCode();
        switch(r6) {
            case -1790517947: goto L_0x006c;
            case -861391249: goto L_0x0044;
            case 3571: goto L_0x0062;
            case 104461: goto L_0x003a;
            case 110356: goto L_0x0027;
            case 93029210: goto L_0x0030;
            case 110376974: goto L_0x004e;
            case 1864941562: goto L_0x0058;
            default: goto L_0x0021;
        };
    L_0x0021:
        r1 = r5;
    L_0x0022:
        switch(r1) {
            case 0: goto L_0x0076;
            case 1: goto L_0x0078;
            case 2: goto L_0x007a;
            case 3: goto L_0x007c;
            case 4: goto L_0x007e;
            case 5: goto L_0x0080;
            case 6: goto L_0x0082;
            case 7: goto L_0x0084;
            default: goto L_0x0025;
        };
    L_0x0025:
        r1 = r2;
        goto L_0x0016;
    L_0x0027:
        r6 = "osx";
        r6 = r0.equals(r6);
        if (r6 == 0) goto L_0x0021;
    L_0x002f:
        goto L_0x0022;
    L_0x0030:
        r1 = "apple";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0038:
        r1 = r2;
        goto L_0x0022;
    L_0x003a:
        r1 = "ios";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0042:
        r1 = r3;
        goto L_0x0022;
    L_0x0044:
        r1 = "android";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x004c:
        r1 = r4;
        goto L_0x0022;
    L_0x004e:
        r1 = "tizen";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0056:
        r1 = 4;
        goto L_0x0022;
    L_0x0058:
        r1 = "samsung";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0060:
        r1 = 5;
        goto L_0x0022;
    L_0x0062:
        r1 = "pc";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x006a:
        r1 = 6;
        goto L_0x0022;
    L_0x006c:
        r1 = "smartphone";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0021;
    L_0x0074:
        r1 = 7;
        goto L_0x0022;
    L_0x0076:
        r1 = r2;
        goto L_0x0016;
    L_0x0078:
        r1 = r2;
        goto L_0x0016;
    L_0x007a:
        r1 = r3;
        goto L_0x0016;
    L_0x007c:
        r1 = r4;
        goto L_0x0016;
    L_0x007e:
        r1 = r4;
        goto L_0x0016;
    L_0x0080:
        r1 = r4;
        goto L_0x0016;
    L_0x0082:
        r1 = r3;
        goto L_0x0016;
    L_0x0084:
        r1 = r3;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armis.blueborne_detector.VulnerabilityUtils.calcDeviceRisk(android.bluetooth.BluetoothDevice):int");
    }

    public static String getDeviceOs(BluetoothDevice device) {
        String macPrefix = device.getAddress().substring(0, 8);
        int majorDeviceClass = device.getBluetoothClass().getMajorDeviceClass();
        if (Manuf.APPLE.contains(macPrefix)) {
            if (majorDeviceClass == 256) {
                return "osx";
            }
            if (majorDeviceClass == 512) {
                return "ios";
            }
            if (!(majorDeviceClass != 7936 || device.getName() == null || device.getName().toLowerCase().contains("mac"))) {
                return "ios";
            }
        }
        if (Manuf.SAMSUNG.contains(macPrefix)) {
            if (majorDeviceClass == 512) {
                return "android";
            }
            if (majorDeviceClass == 1792) {
                return "tizen";
            }
            if (device.getName() == null || !device.getName().contains("TV")) {
                return "samsung";
            }
            return "tizen";
        } else if (device.getName() != null && device.getName().contains("Gear")) {
            return "tizen";
        } else {
            if (majorDeviceClass == 512 && Manuf.ANDROIDS.contains(macPrefix)) {
                return "android";
            }
            if (majorDeviceClass == 256 && !Manuf.APPLE.contains(macPrefix)) {
                return "pc";
            }
            if (majorDeviceClass != 512 || Manuf.APPLE.contains(macPrefix)) {
                return null;
            }
            return "smartphone";
        }
    }

    public static String getManufacturer(String mac) {
        String macPrefix = mac.substring(0, 8);
        if (Manuf.APPLE.contains(macPrefix)) {
            return "Apple";
        }
        if (Manuf.GOOGLE.contains(macPrefix)) {
            return "Google";
        }
        if (Manuf.SAMSUNG.contains(macPrefix)) {
            return "Samsung";
        }
        if (Manuf.LG.contains(macPrefix)) {
            return "LG";
        }
        if (Manuf.HTC.contains(macPrefix)) {
            return "HTC";
        }
        if (Manuf.ONEPLUS.contains(macPrefix)) {
            return "OnePlus";
        }
        if (Manuf.MOTOROLA.contains(macPrefix)) {
            return "Motorola";
        }
        if (Manuf.SONY.contains(macPrefix)) {
            return "Sony";
        }
        if (Manuf.HUAWEI.contains(macPrefix)) {
            return "Huawei";
        }
        if (Manuf.XIAOMI.contains(macPrefix)) {
            return "Xiaomi";
        }
        if (Manuf.MEIZU.contains(macPrefix)) {
            return "Meizu";
        }
        if (Manuf.LENOVO.contains(macPrefix)) {
            return "Lenovo";
        }
        if (Manuf.OPPO.contains(macPrefix)) {
            return "Oppo";
        }
        if (Manuf.VIVO.contains(macPrefix)) {
            return "Vivo";
        }
        if (Manuf.ASUS.contains(macPrefix)) {
            return "Asus";
        }
        if (Manuf.ZTE.contains(macPrefix)) {
            return "ZTE";
        }
        return null;
    }
}