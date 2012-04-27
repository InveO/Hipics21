package jet.hipics21.ui;

import jet.components.ui.htmllink.common.UIHtmlLinkComponent;
import jet.components.ui.table.common.UITableComponent2;
import jet.container.managers.ui.interfaces.UIComponentFinder;
import jet.container.nuts.ui.EventDrivenUINut;
import jet.lifecycle.annotations.Initializer;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;

public class HelpNut extends EventDrivenUINut {

    /**
     * 
     */
  //  private static final long serialVersionUID = 1381637223067438077L;

    @Initializer
    public void doHelpNutInit() throws JETException {
     //   final UITableComponent2 uiTable = (UITableComponent2) UIComponentFinder.findComponent("helpTable", getMainComponent());

 /*       uiTable.setValueAt(0, 0, "Accounts Receivable");
        uiTable.setValueAt(1, 0, "Company data");
        uiTable.setValueAt(2, 0, "Contacts");
        uiTable.setValueAt(3, 0, "Domains and Company Setup");
        uiTable.setValueAt(4, 0, "Financial Accounting");
        uiTable.setValueAt(5, 0, "Monitoring and Logging");
        uiTable.setValueAt(6, 0, "SuisseID Demo");
        uiTable.setValueAt(7, 0, "Technical Data");
        uiTable.setValueAt(8, 0, "User Interface");

        addPdfToTable(0, "http://ulmo.inveo.be/amanda/html/doc/Accounts Receivable.pdf", uiTable);
        addPdfToTable(1, "http://ulmo.inveo.be/amanda/html/doc/Company Data.pdf", uiTable);
        addPdfToTable(2, "http://ulmo.inveo.be/amanda/html/doc/contacts.pdf", uiTable);
        addPdfToTable(3, "http://ulmo.inveo.be/amanda/html/doc/Domains and company setup.pdf", uiTable);
        addPdfToTable(4, "http://ulmo.inveo.be/amanda/html/doc/Financial Accounting.pdf", uiTable);
        addPdfToTable(5, "http://ulmo.inveo.be/amanda/html/doc/logging and monitoring.pdf", uiTable);
        addPdfToTable(6, "http://ulmo.inveo.be/amanda/html/doc/SuisseIDDemo.pdf", uiTable);
        addPdfToTable(7, "http://ulmo.inveo.be/amanda/html/doc/Technical_Data.pdf", uiTable);
        addPdfToTable(8, "http://ulmo.inveo.be/amanda/html/doc/User Interface.pdf", uiTable);  */
    }

 /*   private void addPdfToTable(final int row, final String link, final UITableComponent2 uiTable) {
        final Model m = new SimpleEventModelImpl();
        m.setNodeValue("PDF");
        m.setAttribute(UIHtmlLinkComponent.LINK, link);
        uiTable.setNodeAt(row, 1, m);
    } */

}
