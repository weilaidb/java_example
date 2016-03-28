//
//�����ļ��� 09:31
//
//����ʱ����ͨ��ʹ��listFiles����������ȡ�ļ����е�������Ŀ������ͨ���ݹ���ʾ�����Ĳ㼶�ṹ��
package com.jikexueyuan.filescan.main;

import java.io.File;

public class Scanner {

	public static void main(String[] args) {
		printFile(new File("./"), 1);
	}
	
	public static void printFile(File dir, int tab) {
		if (dir.isDirectory()) {
			File next[] = dir.listFiles();
			for (int i = 0; i < next.length; i++) {
				for (int j = 0; j < tab; j++) {
					System.out.print("|--");
				}
				System.out.println(next[i].getName());
				if (next[i].isFile()) {
				} else {
					printFile(next[i], tab + 1);
				}
			}
		}
	}
	
	

}


/*
|--.classpath
|--.gitignore
|--.project
|--.settings
|--|--org.eclipse.jdt.core.prefs
|--bin
|--|--com
|--|--|--jikexueyuan
|--|--|--|--filescan
|--|--|--|--|--main
|--|--|--|--|--|--Scanner.class
|--src
|--|--com
|--|--|--jikexueyuan
|--|--|--|--filescan
|--|--|--|--|--main
|--|--|--|--|--|--Scanner.java

*/