package swtawtbridge;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BorderLayoutDemo {
    
  public static void main(String[] args) {

    JPanel container = new JPanel();
    java.awt.BorderLayout layout = new java.awt.BorderLayout();
    container.setLayout(layout);
      
    container.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
    container.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);
    container.add(new JButton("LINE_START"), BorderLayout.LINE_START);
    container.add(new JButton("LINE_END"), BorderLayout.LINE_END);
    container.add(new JButton("CENTER"), BorderLayout.CENTER);
    
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("SWT and Swing/AWT Example");

    Composite comp = new Composite(shell, SWT.EMBEDDED); 
    
    java.awt.Frame embedded = SWT_AWT.new_Frame(comp);
    embedded.add(container);
    
    comp.pack();
    
    shell.setLayout(new FillLayout());
    
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}