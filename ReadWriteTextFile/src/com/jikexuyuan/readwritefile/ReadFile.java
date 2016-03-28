//
//�ļ��ļ򵥶�д 11:47
//
//����ʱ����FileInputStream��FileOutputStream��ʹ�÷�����ʵ���ı��ļ��Ķ�ȡ��д����
package com.jikexuyuan.readwritefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("text.txt");
		if (file.exists()) {
			System.err.println("exist");

				try {
					FileInputStream fis = new FileInputStream(file);
//					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					InputStreamReader isr = new InputStreamReader(fis, "GB2312");
					BufferedReader br = new BufferedReader(isr);
					
					String line;
					while((line = br.readLine()) != null) {
						System.out.println(line);
					}
					br.close();
					isr.close();
					fis.close();
				} catch (FileNotFoundException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
		
		try {
			File newFile = new File("newtext.txt");
			FileOutputStream fos = new FileOutputStream(newFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write("afdfaddfdafd");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("����ʱ����File�࣬File�����������ļ����ļ��У�ͨ��File�࣬���Զ��ļ����ļ���ִ�зḻ�Ĳ��������ҿ��Ի�ȡ�ļ���·������С���ļ�������Ϣ��\n");
			bw.write("afdfaddfdafd");
			
			bw.close();
			osw.close();
			fos.close();
			
			System.out.println("д�����");
			
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
