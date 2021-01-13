package tool;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//1.测试爬取一百个网页链接
		WbeAddress web = new WbeAddress("http://www.netbian.com/meinv/index.htm",1);
		for(int i=2;i<=100;i++) {
			web = new WbeAddress("http://www.netbian.com/meinv/index_"+i+".htm",i);
		}
		System.out.println("图片链接采取完毕！");
		//2.从网页中找到图片链接，保存到数据库
		ImgLink img = new ImgLink();
		System.out.println("链接全部保存到数据库");
		//3.遍历数据库，将图片写入硬盘，
		SaveImg saveImg = new SaveImg();
		System.out.println("所有图片下载成功！");
	}

}
