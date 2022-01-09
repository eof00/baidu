package downForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import org.jsoup.select.Elements;

import baiduDownload.MyCrawler;
import link.LinkFilter;
import link.Links;
import page.Page;
import page.PageParserTool;
import page.RequestAndResponseTool;
import util.FileTool;


public class DownMain {
	public static DownLoadForm downFrm = new DownLoadForm();

	public static void main(String[] args) {

		// 为读取文件钮增加监听事件
		downFrm.outHButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String path = null;

				path = fileSave();

				downFrm.outHText.setText(path);
			}
		});

		// 为选择保存路径按钮增加监听事件
		downFrm.payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String path = null;

				path = fileSave();

				downFrm.payText.setText(path);
			}
		});
		// 为下载按钮增加监听事件
		downFrm.exeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					// 生成文件
					  DownMain crawler = new DownMain();
				        //crawler.crawling(new String[]{"http://image.baidu.com"});
				      crawler.crawling(new String[]{"http://www.netbian.com/"});

					// 设置格式，保存数据

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	/**
	 * 通过模板生成输出文件
	 * 
	 * @throws Exception
	 */

	private static void excelExcute() throws Exception {
		
		// 1.4、 取得保存文件路径
		String excelSavePath = downFrm.payText.getText().toString();


	}

	/**
	 * 读入文件选择
	 */
	private static String fileSelect() {
		String path = "";
		JFileChooser jfc = new JFileChooser();
		FileFilter fileFilter = new FileFilter(); // 创建过滤器对象
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setFileFilter(fileFilter);
		jfc.showDialog(new JLabel(), "选择");

		if (jfc.getSelectedFile() != null) {
			path = jfc.getSelectedFile().getPath();
		}

		return path;

	}

	/**
	 * 保存路径选择
	 */
	private static String fileSave() {
		String path = "";
		JFileChooser jfc = new JFileChooser();
		FileFilter fileFilter = new FileFilter(); // 创建过滤器对象
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setFileFilter(fileFilter);
		// jfc.showDialog(new JLabel(), "选择");
		int value = jfc.showSaveDialog(null);

		if (value == JFileChooser.APPROVE_OPTION) {

			path = jfc.getSelectedFile().getPath();
		}

		return path;

	}
	
	   /**
     * 使用种子初始化 URL 队列
     *
     * @param seeds 种子 URL
     * @return
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }


    /**
     * 抓取过程
     *
     * @param seeds
     * @return
     */
    public void crawling(String[] seeds) {

        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.netbian.com"))
                //(url.startsWith("http://www.baidu.com"))
                //http://img07file.tooopen.com/
                    return true;
                else
                    return false;
            }
        };

        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {

            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }

            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            //对page进行处理： 访问DOM的某个标签
            Elements es = PageParserTool.select(page,"a");
            if(!es.isEmpty()){
                System.out.println("下面将打印所有a标签： ");
                System.out.println(es);
            }

            //将保存文件
            FileTool.saveToLocal(page);

            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);

            //得到超链接
            Set<String> links = PageParserTool.getLinks(page,"img");
            for (String link : links) {
                Links.addUnvisitedUrlQueue(link);
                System.out.println("新增爬取路径: " + link);
            }
        }
    }

}
