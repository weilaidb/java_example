//
//�ļ����Ե����� 04:38
//
//����ʱ���⽫�ļ��趨Ϊ�ɶ�����д��ֻ����
import java.io.File;


public class SetFileProperty {

	public static void main(String[] args) {
		File file = new File("test.file");
		//���ļ��趨Ϊ��д
		file.setWritable(false);
		file.setWritable(true);
		//���ļ��趨Ϊ�ɶ�
		file.setReadable(false);
		file.setReadable(true);
		//���ļ��趨Ϊֻ��
		file.setReadOnly();
		
	}

}
