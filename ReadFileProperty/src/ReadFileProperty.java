//
//�ļ����ԵĶ�ȡ 11:12
//
//����ʱ�����ж��ļ��Ƿ���ڡ��ļ����ơ�·�����ļ���С���Ƿ����ء��Ƿ�ɶ���д���Ƿ�Ϊ�ļ��еȡ�
import java.io.File;


public class ReadFileProperty {

	public static void main(String[] args) {
		File file = new File("text.txt");
		//�ж��ļ��Ƿ����
		System.out.println("�ж��ļ��Ƿ����" + file.exists());
		//��ȡ�ļ�������
		System.out.println("��ȡ�ļ�������" + file.getName());
		//��ȡ�ļ�·��
		System.out.println("��ȡ�ļ�·�� ��" + file.getPath());
		//��ȡ�ļ�����·��
		System.out.println("��ȡ�ļ�����·����" + file.getAbsolutePath());
		//��ȡ�ļ�����·��
		System.out.println("��ȡ�ļ�����·�� ��" + new File(file.getAbsolutePath()).getParent());
		//��ȡ�ļ���С
		System.out.println("��ȡ�ļ���С�� " + file.length() + "byte");
		System.out.println("��ȡ�ļ���С�� " + (float)file.length()/1000 + "KB");
		//�ж��ļ��Ƿ�����
		System.out.println("�ж��ļ��Ƿ����� :" + file.isHidden());
		//�ж��ļ��Ƿ�ɶ�
		System.out.println("�ж��ļ��Ƿ�ɶ���" + file.canRead());
		//�ж��ļ��Ƿ��д
		System.out.println("�ж��ļ��Ƿ��д��" + file.canWrite());
		//�ж��ļ��Ƿ�Ϊ�ļ���
		System.out.println("�ж��ļ��Ƿ�Ϊ�ļ��� :" + file.isDirectory());
		
	}

}
//
//�ж��ļ��Ƿ����true
//��ȡ�ļ�������text.txt
//��ȡ�ļ�·�� ��text.txt
//��ȡ�ļ�����·����D:\Java\javagui\ReadFileProperty\text.txt
//��ȡ�ļ�����·�� ��D:\Java\javagui\ReadFileProperty
//��ȡ�ļ���С�� 30byte
//��ȡ�ļ���С�� 0.03KB
//�ж��ļ��Ƿ����� :false
//�ж��ļ��Ƿ�ɶ���true
//�ж��ļ��Ƿ��д��false
//�ж��ļ��Ƿ�Ϊ�ļ��� :false
