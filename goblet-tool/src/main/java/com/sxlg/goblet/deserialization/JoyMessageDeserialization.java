package com.sxlg.goblet.deserialization;

public class JoyMessageDeserialization {
    private static final int BUFFER_SIZE = 16 * 1024 * 1024;
    /**
     * 执行解码操作，默认大端字节序
     * <br> bytes ： 待解码字节缓冲区
     * <br> bytesLength ：缓冲区 bytes 中，待解码的字节总数
     */
    public static String doDecoding(byte[] bytes, int bytesLength) {
        /** 保存解码后的数据 */
        char[] charData = null;
        int charData_index = 0;
        String result = null;

        if (bytes != null
                && (bytesLength = Math.min(bytesLength, bytes.length)) > 0) {
            // 1 从一个随机位置开始解码
//			int startIndex = new Random().nextInt(bytesLength);
            // 2 解码所有字节数据
            int startIndex = 0;

            /** 字符类型（参考 getType 方法） */
            int type = 0;
            /** 保存一个字符的 UTF-8 编码 */
            byte[] encodedCharData = new byte[4];
            int encodedCharData_index = 0;
            // 初始化
            charData = new char[BUFFER_SIZE];

            for (; startIndex < bytesLength; ++startIndex) {
                if (encodedCharData_index == 0 && (type = getType(bytes[startIndex])) < 0) {
                    // 直到找到一个 UTF-8 编码的起始字节为止
                    continue;
                }
                // 读取一个字符的编码
                encodedCharData[encodedCharData_index++] = bytes[startIndex];
                if (encodedCharData_index < type) {
                    // 继续读取该字符剩余的其它字节
                    continue;
                }
                // 解码一个字符
                if (type == 1) {
                    // 1
                    // ascii 字符
                    charData[charData_index++] = (char) Byte.toUnsignedInt(encodedCharData[0]);
                } else if (type == 2) {
                    // 2
                    // 提取第一个字节，屏蔽前 3 个 bit
                    int b1 = 0b00011111 & Byte.toUnsignedInt(encodedCharData[0]);
                    // 提取第二个字节，屏蔽前 2 个 bit
                    int b2 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[1]);
                    int aChar = (b1 << 6) | b2;
                    charData[charData_index++] = (char)aChar;
                } else if (type == 3) {
                    // 3
                    // 提取第一个字节，屏蔽前 4 个 bit
                    int b1 = 0b00001111 & Byte.toUnsignedInt(encodedCharData[0]);
                    // 提取第二个字节，屏蔽前 2 个 bit
                    int b2 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[1]);
                    // 提取第三个字节，屏蔽前 2 个 bit
                    int b3 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[2]);
                    int aChar = (b1 << 12) | (b2 << 6) | b3;
                    charData[charData_index++] = (char)aChar;
                } else if (type == 4) {
                    // 4
                    // 提取第一个字节，屏蔽前 3 个 bit
                    int b1 = 0b00000111 & Byte.toUnsignedInt(encodedCharData[0]);
                    // 提取第二个字节，屏蔽前 2 个 bit
                    int b2 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[1]);
                    // 提取第三个字节，屏蔽前 2 个 bit
                    int b3 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[2]);
                    // 提取第四个字节，屏蔽前 2 个 bit
                    int b4 = 0b00111111 & Byte.toUnsignedInt(encodedCharData[3]);
                    int aChar = (b1 << 18) | (b2 << 12) | (b3 << 6) | b4;
                    charData[charData_index++] = (char)aChar;
                }
                // 清理工作
                // 清除已缓存且已完成解码的字符编码，继续处理下一个字符编码
                encodedCharData_index = 0;
            }
            result = new String(charData, 0, charData_index);
        }
        return result;
    }

    /**
     * 该方法用于确认参数字节 aByte 是否为一个 UTF-8 编码的起始字节， 返回值说明， <br>
     * -1：字节 aByte 非起始字节， <br>
     * 1：起始字节，类型为 1，对应字符占 1 个字节空间（实为 ASCII 字符） <br>
     * 2：起始字节，类型为 2，对应字符占 2 个字节空间 <br>
     * 3：起始字节，类型为 3，对应字符占 3 个字节空间 <br>
     * 4：起始字节，类型为 4，对应字符占 4 个字节空间
     */
    public static int getType(byte aByte) {
        int type = 0b11110000 & aByte; // ‘0b11110000’ 为十进制数 240 的二进制表示
        if (0 <= type && type < 128) {
            return 1;
        } else if (128 <= type && type < 192) {
            return -1;
        } else if (192 <= type && type < 224) {
            return 2;
        } else if (224 <= type && type < 240) {
            return 3;
        } else if (240 <= type && type < 248) {
            return 4;
        }
        return -1;
    }
}
