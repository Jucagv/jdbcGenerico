package view;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class GenericTable extends AbstractTableModel{

	private List<String[]> data;
	
	private List<String> columns;
	
	public GenericTable() {
		data = null;
		columns = null;
	}
	
	public void update(List<String> columns, List<String[]> data) {
		this.columns = columns;
		this.data = data;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (data != null) {
			return data.size();
		}
		
		return 0;
	}
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		if (columns != null) {
			return columns.get(column);
		}
		
		return "";
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if (columns != null) {
			return columns.size();
		}
		
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String[] row = data.get(rowIndex);
		return row[columnIndex];
	}

}
