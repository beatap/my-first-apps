package com.user.app.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData; 
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.BoxLayout.BoxLayoutPack;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UserApp implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
	
		
		 final FormPanel userPanel = new FormPanel();
		 userPanel.setHeading("Panel użytkownika");
		 userPanel.setWidth(850);
		 userPanel.setAutoHeight(true);
		 userPanel.setPagePosition(100, 30);
		 userPanel.setCollapsible(false);
		 userPanel.setScrollMode(Scroll.AUTO);
		 userPanel.setFrame(true);
		 //userPanel.setShadow(true);
		 
		 final FieldSet fieldSet = new FieldSet();
		 //fieldSet.setCollapsible(true);
		 //fieldSet.setExpanded(false);
		 fieldSet.setWidth(400);
		 fieldSet.setAutoHeight(true);
		 fieldSet.setHeading("Dodaj nowego użytkownika");
		 
		 FormLayout layout = new FormLayout();
		 layout.setLabelWidth(100);
		 fieldSet.setLayout(layout);
		 
		 
		 final TextField<String> userName = new TextField<String>();
		 userName.setEnabled(true);
		 userName.setName("imie");
		 userName.setFieldLabel("* Imię");
		 userName.setAllowBlank(false);
		 userName.getMessages().setBlankText("pole nie może być puste!");
		 userName.setToolTip("Proszę podać od 1 do 80 znaków.");
		 userName.addListener(Events.KeyUp, new KeyListener() {
			 
			 @Override
			 public void handleEvent(ComponentEvent e){
				 if(userName.getValue().length() > 80){
					 String subStr = userName.getValue().substring(0, 80);
					 e.stopEvent();
					 userName.setValue(subStr);
				 }
			 } 
		 });
		 fieldSet.add(userName, new FormData("90%"));
		 
		 final TextField<String> userLastName = new TextField<String>();
		 userLastName.setEnabled(true);
		 userLastName.setName("nazwisko");
		 userLastName.setFieldLabel("* Nazwisko");
		 userLastName.setAllowBlank(false);
		 userLastName.getMessages().setBlankText("pole nie może być puste!");
		 userLastName.setToolTip("Proszę podać od 1 do 80 znaków.");
		 userLastName.addListener(Events.KeyUp, new KeyListener() {
			 
			 @Override
			 public void handleEvent(ComponentEvent e){
				 if(userLastName.getValue().length() > 80){
					 String subStr = userLastName.getValue().substring(0, 80);
					 e.stopEvent();
					 userLastName.setValue(subStr);
				 }
			 }
			 
		 });
		 fieldSet.add(userLastName, new FormData("90%"));
		 
		 final DateField birthday = new DateField();
		 birthday.setName("dataUrodzenia");
		 birthday.setFieldLabel("* Data urodzenia");
		 birthday.setAllowBlank(false);
		 birthday.getMessages().setBlankText("pole nie może być puste!");
		 birthday.getMessages().setInvalidText("nieprawidłowy format!");
		 birthday.setToolTip("Prawidłowy format: YYYY-MM-DD.");
		 fieldSet.add(birthday, new FormData("90%"));
		 
		 final SimpleComboBox<String> combo = new SimpleComboBox<String>();
		 combo.add("Gdańsk");
		 combo.add("Lublin");
		 combo.add("Kraków");
		 combo.add("Wrocław");
		 combo.add("Warszawa");
		 combo.setTriggerAction(TriggerAction.ALL);
		 combo.setName("miasto");
		 combo.setFieldLabel("* Miasto");
		 combo.setAllowBlank(false);
		 combo.getMessages().setBlankText("pole nie może być puste!");
		 combo.setEmptyText("wybierz miasto");
		 fieldSet.add(combo, new FormData("90%"));
		 
		 final TextField<String> userPesel = new TextField<String>();
		 userPesel.setName("pesel");
		 userPesel.setFieldLabel("* Pesel");
		 userPesel.setAllowBlank(false);
		 userPesel.setMinLength(11);
		 userPesel.getMessages().setBlankText("pole nie może być puste!");
		 userPesel.getMessages().setMinLengthText("krótki numer PESEL!");
		 userPesel.setToolTip("Proszę podać 11 cyfrowy numer.<br>Prawidłowy format: xxxxxxxxx");
		 userPesel.addListener(Events.KeyUp, new KeyListener() {
			 
			 @Override
			 public void handleEvent(ComponentEvent e){
				 
				 if(userPesel.getValue().length() > 11){
					 
					 String subStr = userPesel.getValue().substring(0, 11);
					 e.stopEvent();
					 userPesel.setValue(subStr);
				 }
			
			 }
			 
		 });
		 userPesel.setValidator(new Validator() {
			
			@Override
			public String validate(Field<?> field, String value) {
				if(field == userPesel){
					if(value.length() == 11) {
						
						for(int i=0; i < 11; i++){
							if(value.charAt(i)<'0' || value.charAt(i) >'9')
								return "nieprawidłowy znak!";
						}
						
						Boolean _pesel = CheckService.sprawdz(value);
						
						if(_pesel == false)
							return "nieprawidłowy numer PESEL!";						
					}
				}
				
				return null;
			}
		});
		 fieldSet.add(userPesel, new FormData("90%"));
		 
		 final TextField<String> userMail = new TextField<String>();
		 userMail.setName("adresEmail");
		 userMail.setFieldLabel("* E-mail");
		 userMail.setAllowBlank(false);
		 userMail.setRegex("^([a-zA-Z0-9-._])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})$");
		 userMail.getMessages().setRegexText("nieprawidłowy format!");
		 userMail.getMessages().setBlankText("pole nie może być puste!");
		 userMail.setToolTip("Proszę podać od 1 do 80 znaków.");
		 userMail.addListener(Events.KeyUp, new KeyListener() {
			 
			 @Override
			 public void handleEvent(ComponentEvent e){
				 if(userMail.getValue().length() > 80){
					 String subStr = userMail.getValue().substring(0, 80);
					 e.stopEvent();
					 userMail.setValue(subStr);
				 }
			 }
			 
		 });
		 fieldSet.add(userMail, new FormData("90%"));
		 
		  final CheckBox check = new CheckBox();
		 check.setName("newsletter");
		 check.setBoxLabel("<p style='text-align: left; font-size: 11px;'>Wyrażam zgodę na przesyłanie mi informacji handlowych na podany<br>adres e-mail</p>");
		 check.setValue(false);
		 check.setHideLabel(true);
		 check.setAutoHeight(true);
		 fieldSet.add(check, new FormData("100% -95"));
		 
		 
		 Label label1 = new Label("<b>* - pole obowiązkowe</b><br>");
		 fieldSet.add(label1);
		 
		 label1 = new Label("<b>Użytkownik powinien mieć ukończone 18 lat.</b>");
		 fieldSet.add(label1);
		 
		 
		 //Button btnCancel = new Button();
		 //btnCancel.setText("Anuluj");
		 
		 Button btnEnter = new Button();
		 btnEnter.setText("Zatwierdź");	
		 

		 
		 LayoutContainer container = new LayoutContainer();
		 HBoxLayout hbox = new HBoxLayout();
		 hbox.setPadding(new Padding(3, 30, 3, 0));
		 hbox.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);
		 hbox.setPack(BoxLayoutPack.END);
		 
		 container.setLayout(hbox);
		 container.setBorders(true);
		 
		 HBoxLayoutData layoutData = new HBoxLayoutData(new Margins(20, 5, 0, 0));
		 //container.add(btnCancel, layoutData);	
		 container.add(btnEnter, layoutData);
		 
		 fieldSet.add(btnEnter);
		 userPanel.add(fieldSet);
		 
		 FieldSet fieldSet2 = new FieldSet();
		 fieldSet2.setCollapsible(false);
		 fieldSet2.setHeading("Lista użytkowników");
		 
		 PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(UserService.getUsers());
		 PagingLoader loader = new BasePagingLoader(proxy);
		 loader.setRemoteSort(true);
		 //loader.setSortField("id");
		 //loader.setSortDir(SortDir.ASC);
		 ListStore<User> userList = new ListStore<User>(loader);
		 userList.setMonitorChanges(true);
		 final PagingToolBar toolBar = new PagingToolBar(5);
		 toolBar.bind(loader);
		 loader.load(0, 5);
		
		      
		      
			    GridCellRenderer<User> delRenderer = new GridCellRenderer<User>() {   
			    	  
			        private boolean init;   
			    
			        public Object render(final User model, String property, ColumnData config, final int rowIndex,   
			            final int colIndex, ListStore<User> store, final Grid<User> grid) {   
			          if (!init) {   
			            init = true;   
			            grid.addListener(Events.ColumnResize, new Listener<GridEvent<User>>() {   
			    
			              public void handleEvent(GridEvent<User> be) {   
			                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {   
			                  if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null  
			                      && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {   
			                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);   
			                  }   
			                }   
			              }   
			            });   
			          }   
			    
			          Button btndel = new Button((String) model.get(property), new SelectionListener<ButtonEvent>() {   
			            @Override  
			            public void componentSelected(ButtonEvent ce) {   
			            	UserService.usunUzytkownika(model);
			            	grid.getStore().commitChanges();
			            	//grid.getStore().getLoader().load();
			            	return;
			            }   
			          });    
			          btndel.setText("usuń");
			    
			          return btndel;   
			        }   
			      };
			      
			      final Label hideLab = new Label();
			      hideLab.setVisible(false);
			      fieldSet.add(hideLab);
			      
				    GridCellRenderer<User> editRenderer = new GridCellRenderer<User>() {   
				    	  
				        private boolean init;   
				    
				        public Object render(final User model, final String property, ColumnData config, final int rowIndex,   
				            final int colIndex, ListStore<User> store, final Grid<User> grid) {   
				          if (!init) {   
				            init = true;   
				            grid.addListener(Events.ColumnResize, new Listener<GridEvent<User>>() {   
				    
				              public void handleEvent(GridEvent<User> be) {   
				                for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {   
				                  if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null  
				                      && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {   
				                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10); 
				                  }   
				                }   
				              }   
				            });   
				          }   
				    
				          Button btnedit = new Button((String) model.get(property), new SelectionListener<ButtonEvent>() {   
				            @Override  
				            public void componentSelected(ButtonEvent ce) {  
				            	User _pobierz = UserService.pobierzUzytkownika(model.getId());
				            	hideLab.setText(Integer.toString(model.getId()));
				            	userName.setValue(_pobierz.getImie());
				            	userLastName.setValue(_pobierz.getNazwisko());
				            	birthday.setValue(_pobierz.getDataUrodzenia());
				            	combo.setSimpleValue(_pobierz.getMiasto());
				            	userPesel.setValue(_pobierz.getPesel());
				            	userMail.setValue(_pobierz.getAdresEmail());
				            	check.setValue(_pobierz.getNewsletter());
				            	
				            	fieldSet.setHeading("Edycja użytkownika");
				            	
				            	//if(!fieldSet.isEnabled())
				            		//fieldSet.setExpanded(true);
				            	
				            }   
				          });   
				          btnedit.setText("edytuj");
				    
				          return btnedit;   
				        }   
				      };			      
		 
		 List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		 
		 ColumnConfig column = new ColumnConfig();
		 column.setId("imie");
		 column.setHeader("Imię");
		 column.setWidth(80);
		 configs.add(column);
		 
		 column = new ColumnConfig("nazwisko", "Nazwisko", 100);
		 configs.add(column);
		 
		 column = new ColumnConfig("dataUrodzenia", "Data urodzenia", 100);
		 column.setDateTimeFormat(DateTimeFormat.getFormat("yyyy-mm-dd"));
		 configs.add(column);
		 
		 column = new ColumnConfig("miasto", "Miasto", 100);
		 configs.add(column);
		 
		 column = new ColumnConfig("pesel", "PESEL", 90);
		 configs.add(column);
		 
		 column = new ColumnConfig("adresEmail", "Adres e-mail", 140);
		 configs.add(column);
		 
		 column = new ColumnConfig("newsletter", "Newsletter", 80);
		 configs.add(column);

		 column = new ColumnConfig("edit", "Edytuj", 50);
		 column.setRenderer(editRenderer);
		 configs.add(column);
		 
		 column = new ColumnConfig("delete", "Usuń", 50);
		 column.setRenderer(delRenderer);
		 configs.add(column);
		 
		 //ListStore<User> userList = new ListStore<User>();
		 //userList.add(UserService.getUsers());
		 
		 ColumnModel columModel = new ColumnModel(configs);
		 final Grid<User> grid = new Grid<User>(userList, columModel);
		 grid.setStyleAttribute("borderTop", "none");
		 grid.setAutoExpandColumn("imie");
		 grid.setBorders(true);
		 grid.setStripeRows(true);
		 grid.setAutoHeight(true);
		 grid.setAutoWidth(true);
		 grid.setColumnLines(true);
		 /*grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		 grid.getSelectionModel().addListener(Events.SelectionChange, 
				 new Listener<SelectionChangedEvent<User>>() {
			 public void handleEvent(SelectionChangedEvent<User> e){
				 
			 }
		});*/
		 fieldSet2.add(grid);
		 fieldSet2.add(toolBar);
		 
		 userPanel.add(fieldSet2);
		 
		 RootPanel.get().add(userPanel);
		 
		 btnEnter.addSelectionListener(new SelectionListener<ButtonEvent>() {
				
				@Override
				public void componentSelected(ButtonEvent ce) {
					
					User _user = new User();
					
					_user.set("imie", userName.getValue());
					_user.set("nazwisko", userLastName.getValue());
					_user.set("dataUrodzenia", birthday.getRawValue());
					_user.set("miasto", combo.getRawValue());
					_user.set("pesel", userPesel.getValue());
					_user.set("adresEmail", userMail.getValue());
					_user.set("newsletter", check.getValue());					
					
				
				if((!(userName.getValue()).equals("")) && (!(userLastName.getValue()).equals(""))
						&& (!(birthday.getValue()).equals(null)) && (!(combo.getValue()).equals(null))
						&& (!(userPesel.getValue()).equals("")) && (!(userMail.getValue()).equals(""))){

					
					if((CheckService.sprawdzWiek(birthday.getRawValue())) == false){
						MessageBox.alert("Uwaga", "Użytkownik musi mieć skończone 18 lat.", null);
						return;
					}
					
				if((userName.isValid() == false)|| (userLastName.isValid() == false) ||
							(birthday.isValid() == false) || (combo.isValid() == false) ||
							(userPesel.isValid() == false) || (userMail.isValid() == false)){
						MessageBox.alert("Uwaga", "Popraw błędy.", null);
						return;
				}
				else {
						//Info.display("Validator", "false");
						if((fieldSet.getHeading()).equals("Dodaj nowego użytkownika")){
							UserService.zapiszUzytkownika(_user);
							grid.getStore().getLoader().load();
							//grid.getStore().commitChanges();
	
							userPanel.reset();
							MessageBox.info("Informacja", "Użytkownik został poprawnie dodany.", null);
							//return;
						}
						if((fieldSet.getHeading()).equals("Edycja użytkownika")) {
							
							fieldSet.setHeading("Dodaj nowego użytkownika");
							UserService.edytujUzytkownika(Integer.parseInt(hideLab.getText()), _user);
							//grid.getStore().commitChanges();
							grid.getStore().getLoader().load();
							//fieldSet.setExpanded(false);
							userPanel.reset();
							//return;
							//MessageBox.info("Informacja", "Zmiany zostały poprawnie wprowadzone.", null);
						}
						
					}
				}
				else {
					MessageBox.alert("Uwaga", "Wypełnij wszystkie wymagane pola.", null);
					return;
				}

				}
			});	
	}
}
