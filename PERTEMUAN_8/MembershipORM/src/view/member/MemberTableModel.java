    package view.member;

    import java.util.List;
    import javax.swing.table.AbstractTableModel;
    import model.Member;

    public class MemberTableModel extends AbstractTableModel {
        
        private String[] columnNames = { "Nama", "Jenis Member"};
        private List<Member> data;

        public MemberTableModel(List<Member> data) {
            this.data = data;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col){
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            Member rowItem = data.get(row);
            String value = "";
        
            switch(col) {
                case 0:
                    value = rowItem.getNama();
                    break;
                case 1:
                    // Add null check for getJenisMember()
                    if (rowItem.getJenisMember() != null) {
                        value = rowItem.getJenisMember().getNama();
                    } else {
                        value = "No Jenis Member";  // or any default value
                    }
                    break;
            }
        
            return value;
        }
        

        public boolean isCellEditable(int row, int col){
            return false;
        }

        public void add(Member value){
            data.add(value);
            fireTableRowsInserted(data.size() - 1, data.size() - 1);
        }

        public void removeMember(Member member) {
            data.remove(member);
            fireTableRowsDeleted(data.size() - 1, data.size() - 1);
        }

        public void setData(List<Member> data) {
            this.data = data;
        }
    }
