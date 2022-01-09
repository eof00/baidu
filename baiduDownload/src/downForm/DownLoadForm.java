package downForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class DownLoadForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4721656779927911060L;

	// 定义Frame
	private JFrame frame = new JFrame("爬虫");

	public JTextField payText = new JTextField("");

	public JButton payButton = new JButton("...");

	// 线程数
	public JTextField payInsText = new JTextField("1");

	// 最大下载数

	public JTextField payHolText = new JTextField("1");

	// 
	public JTextField outHText = new JTextField("");

	public JButton outHButton = new JButton("...");

	public JButton exeButton = new JButton("开始下载");
     public ButtonGroup group = new ButtonGroup();
     
     public JTextField fileText = new JTextField("");


	public JTextField getPayText() {
		return payText;
	}

	public void setPayText(JTextField payText) {
		this.payText = payText;
	}

	// 生成文件保存区域
	private JPanel panelFileSave = new JPanel();

	public DownLoadForm() {

		// 设置窗体样式
		frame.setBounds(500, 200, 330, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体为不可改变尺寸
		frame.setResizable(false);
		// 设置窗体布局形式
		frame.setLayout(null);
		//网站选择
		JPanel panelFileWs = new JPanel();
		// 数据文件选择区域
		JPanel panelFileSel = new JPanel();

		// 操作按钮区域
		JPanel panelButton = new JPanel();
		
		// 设置不同网站选择
//		panelFileWs.setBounds(10, 10, 300, 60);// 位置
//		panelFileWs.setBorder(BorderFactory.createEtchedBorder());// 边框
//		panelFileWs.setBorder(BorderFactory.createTitledBorder("网站")); // 标题
	
		
		// 设置文件选择区样式
		panelFileSel.setBounds(10, 10, 300, 100);// 位置
		panelFileSel.setBorder(BorderFactory.createEtchedBorder());// 边框
		panelFileSel.setBorder(BorderFactory.createTitledBorder("设置")); // 标题

		// 设置文件保存区样式
		panelFileSave.setBounds(10, 115, 300, 60);// 位置
		panelFileSave.setBorder(BorderFactory.createEtchedBorder());// 边框
		panelFileSave.setBorder(BorderFactory.createTitledBorder("保存"));// 标题

		// 设置录入区域
		JPanel panelFileIns = new JPanel();
		panelFileIns.setBounds(10, 185, 300, 60);// 位置
		panelFileIns.setBorder(BorderFactory.createEtchedBorder());// 边框
		panelFileIns.setBorder(BorderFactory.createTitledBorder("设置"));// 标题

		// 设置按钮区样式
		panelButton.setBounds(10, 255, 300, 60);// 位置
		panelButton.setBorder(BorderFactory.createEtchedBorder());// 边框
		panelButton.setBorder(BorderFactory.createTitledBorder("操作"));// 标题
		/*
		 * 增加输入区域
		 */
		
		fileWsPlaceComponents(panelFileWs);
		fileSelPlaceComponents(panelFileSel);
		fileSavePlaceComponents(panelFileSave);

		fileInsPlaceComponents(panelFileIns);
		buttonPlaceComponents(panelButton);
        //增加网站选择区域
		//frame.add(panelFileWs);
		// 增加数据源文件选择区域
		frame.add(panelFileSel);
		// 增加文件保存区域
		frame.add(panelFileSave);
		// 设置录入区域
		frame.add(panelFileIns);
		// 设置按钮区域
		frame.add(panelButton);

		// 使form可见
		frame.setVisible(true);

	}
	/**
	 * 数据源选择区域布局
	 */
	private void fileWsPlaceComponents(JPanel panel) {

		panel.setLayout(null);
		// 文件读取
		JLabel outHLabel = new JLabel("选择:");

		outHLabel.setBounds(30, 20, 80, 25);
		panel.add(outHLabel);

		JRadioButton opBaidu = new JRadioButton("百度",true);//只传了两个参数
	
        group.add(opBaidu);

        opBaidu.setBounds(90, 20, 80, 25);
      
		panel.add(opBaidu);

		
		
	}
	/**
	 * 数据源选择区域布局
	 */
	private void fileSelPlaceComponents(JPanel panel) {
	
		panel.setLayout(null);
		// 文件读取
		JLabel outHLabel = new JLabel("图片地址:");

		outHLabel.setBounds(30, 20, 80, 25);
		panel.add(outHLabel);

		outHText.setBounds(90, 20, 150, 25);
		panel.add(outHText);

		outHButton.setBounds(250,60,30,25);
		panel.add(outHButton);
		
		JCheckBox jcb = new JCheckBox("本地文件:");
		jcb.setBounds(10, 60, 80, 25);
		fileText.setBounds(90, 60, 150, 25);
		panel.add(jcb);
		panel.add(fileText);
		
	}

	/**
	 * 文件保存区域布局
	 */
	private void fileSavePlaceComponents(JPanel panel) {

		panel.setLayout(null);

		// 设置文件保存区域
		// 缺勤扣薪
		JLabel payLabel = new JLabel("保存路径:");

		payLabel.setBounds(30, 20, 80, 25);
		panel.add(payLabel);
//
		payText.setBounds(90, 20, 150, 25);
		panel.add(payText);

		payButton.setBounds(250, 20, 30, 25);
		panel.add(payButton);

	}

	/**
	 * 数据录入区域布局
	 */
	private void fileInsPlaceComponents(JPanel panel) {

		panel.setLayout(null);

		// 设置录入区域
		// 最大线程数
		JLabel payInsLabel = new JLabel("最大线程数:");

		payInsLabel.setBounds(20, 20, 80, 25);
		panel.add(payInsLabel);

		payInsText.setBounds(90, 20, 50, 25);
		payInsText.setEnabled(false);
		
		panel.add(payInsText);

		// 最大下载数
		JLabel payHolLabel = new JLabel("最大下载数:");

		payHolLabel.setBounds(155, 20, 80, 25);
		panel.add(payHolLabel);

		payHolText.setBounds(230, 20, 50, 25);

		payHolText.setEnabled(false);
		panel.add(payHolText);

	}

	/**
	 * 按钮区域布局
	 */
	private void buttonPlaceComponents(JPanel panel) {

		panel.setLayout(null);

		// 生成报表按钮

		exeButton.setBounds(90, 20, 90, 25);
		panel.add(exeButton);

		// 关闭窗口按钮

		JButton closeButton = new JButton("关闭窗口");
		closeButton.setBounds(190, 20, 90, 25);
		panel.add(closeButton);
		// 为关闭按钮增加关闭窗体事件
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

	}

}
