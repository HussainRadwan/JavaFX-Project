package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setMaximized(true);
		
		MediaRental mediaRental = new MediaRental();
		
		boolean empty;
		empty = readingCustomer(mediaRental);
		empty = readingMedia(mediaRental);
		empty = readingCart (mediaRental);
		empty = readingRent(mediaRental);
		
		ImageView IcustB = new ImageView("https://img.icons8.com/color/344/gender-neutral-user.png");
		ImageView ImediaB = new ImageView("https://img.icons8.com/color/344/adobe-media-encoder.png");
		ImageView IrentB = new ImageView("https://img.icons8.com/nolan/344/sell-property.png");
		ImageView image = new ImageView("https://img.icons8.com/color/344/key-exchange.png");
	
		IcustB.setFitHeight(50);
		ImediaB.setFitHeight(50);
		IrentB.setFitHeight(50);
		image.setFitHeight(250);
		
		IcustB.setFitWidth(50);
		ImediaB.setFitWidth(50);
		IrentB.setFitWidth(50);
		image.setFitWidth(250);
		
		Button customerB = new Button("Customer",IcustB);
		Button mediaB = new Button("Media",ImediaB);
		Button rentB = new Button("Rent",IrentB);
		
		Label text = new Label("Media Rental System");
		text.setAlignment(Pos.CENTER);
		
		text.setFont(new Font(" ", 20));
		
		customerB.setMaxWidth(300);
		mediaB.setMaxWidth(300);
		rentB.setMaxWidth(300);
		
		customerB.setStyle("-fx-background-color: LightBlue");
		mediaB.setStyle("-fx-background-color: LightBlue");
		rentB.setStyle("-fx-background-color: LightBlue");
		
		VBox box1 = new VBox(customerB,mediaB,rentB);
		VBox box2 = new VBox(image,text);
		
		box1.setSpacing(30);
		box2.setAlignment(Pos.CENTER);
		box1.setAlignment(Pos.CENTER);
		
		HBox pane = new HBox(box1,box2);
		pane.setSpacing(100);
		pane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(pane,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		customerB.setOnAction(e->{
			
			Button ANC = new Button("Add new Customer");
			Button DC = new Button("Delete Customer");
			Button UC = new Button("Update Information about Customer");
			Button SBid = new Button("Search a Customer by id");
			Button RM = new Button("Return to main page");
			
			ANC.setStyle("-fx-background-color: LightYellow");
			DC.setStyle("-fx-background-color: LightYellow");
			UC.setStyle("-fx-background-color: LightYellow");
			SBid.setStyle("-fx-background-color: LightYellow");
			RM.setStyle("-fx-background-color: LightYellow");
			
			ANC.setPrefSize(300, 40);
			DC.setPrefSize(300, 40);
			UC.setPrefSize(300, 40);
			SBid.setPrefSize(300, 40);
			RM.setPrefSize(300, 40);
			
			VBox order = new VBox(ANC,DC,UC,SBid,RM);
			order.setSpacing(20);
			order.setAlignment(Pos.CENTER);
			scene.setRoot(order);
			
			ANC.setOnAction(a->{
				
				ImageView addcu = new ImageView("https://img.icons8.com/nolan/344/add.png");
				ImageView back = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				addcu.setFitHeight(35);
				addcu.setFitWidth(35);
				back.setFitHeight(35);
				back.setFitWidth(35);
				
				Label id = new Label("Customer ID:");
				Label name = new Label("Customer Name:");
				Label address = new Label("Customer Address:");
				Label mobile = new Label("Customer Mobile:");
				
				id.setFont(new Font(" ", 20));
				name.setFont(new Font(" ", 20));
				address.setFont(new Font(" ", 20));
				mobile.setFont(new Font(" ", 20));
				
				Button addCustomer = new Button("",addcu);
				Button Back = new Button("",back); 
				
				TextField Tid = new TextField();
				TextField Tname = new TextField();
				TextField Taddress = new TextField();
				TextField Tmobile = new TextField();
				
				Tid.setFont(new Font(" ", 20));
				Tname.setFont(new Font(" ", 20));
				Taddress.setFont(new Font(" ", 20));
				Tmobile.setFont(new Font(" ", 20));
				
				HBox ID = new HBox(id,Tid);
				HBox Name = new HBox(name,Tname);
				HBox Address = new HBox(address,Taddress);
				HBox Mobile = new HBox(mobile,Tmobile);
				HBox clice = new HBox(addCustomer,Back);
				
				ID.setAlignment(Pos.CENTER);
				Name.setAlignment(Pos.CENTER);
				Address.setAlignment(Pos.CENTER);
				Mobile.setAlignment(Pos.CENTER);
				clice.setAlignment(Pos.CENTER);
				
				ID.setSpacing(72);
				Name.setSpacing(37);
				Address.setSpacing(20);
				Mobile.setSpacing(30);
				clice.setSpacing(70);
				
				VBox addcust = new VBox(ID,Name,Address,Mobile,clice);
				addcust.setAlignment(Pos.CENTER);
				addcust.setSpacing(15);
				
				Tid.setOnKeyTyped(dis->{
					
					Tid.setDisable(false);
					Tname.setDisable(false);
					Taddress.setDisable(false);
					Tmobile.setDisable(false);
					
				});
				
				Tname.setOnKeyTyped(dis->{
					
					Tid.setDisable(true);
					Tname.setDisable(false);
					Taddress.setDisable(false);
					Tmobile.setDisable(false);
					
				});
				
				Taddress.setOnKeyTyped(dis->{
					
					Tid.setDisable(true);
					Tname.setDisable(true);
					Taddress.setDisable(false);
					Tmobile.setDisable(false);
					
				});
				
				Tmobile.setOnKeyTyped(dis->{
					
					Tid.setDisable(true);
					Tname.setDisable(true);
					Taddress.setDisable(true);
					Tmobile.setDisable(false);
					
				});
				
				scene.setRoot(addcust);
				
				addCustomer.setOnAction(c->{
					
					mediaRental.addCustomer(Tname.getText(), Taddress.getText(), "UNLIMITED", Tmobile.getText(), Tid.getText());
					
					savingfile(mediaRental);
					
					Tid.setDisable(true);
					Tname.setDisable(true);
					Taddress.setDisable(true);
					Tmobile.setDisable(true);
					
				});
				
				Back.setOnAction(b->{
					
					Tid.setDisable(true);
					Tname.setDisable(true);
					Taddress.setDisable(true);
					Tmobile.setDisable(true);
					
					scene.setRoot(order);
				});
			});
			
			DC.setOnAction(d->{
				
				ImageView delete = new ImageView("https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png");
				ImageView back1 = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView find = new ImageView("https://img.icons8.com/external-others-phat-plus/344/external-find-education-and-learning-blue-others-phat-plus.png");
				
				back1.setFitHeight(35);
				back1.setFitWidth(35);
				delete.setFitHeight(35);
				delete.setFitWidth(35);
				find.setFitHeight(35);
				find.setFitWidth(35);
				
				Label id1 = new Label("Customer ID:");
				Label name1 = new Label("Customer Name:");
				Label address1 = new Label("Customer Address:");
				Label mobile1 = new Label("Customer Mobile:");
				
				id1.setFont(new Font(" ", 20));
				name1.setFont(new Font(" ", 20));
				address1.setFont(new Font(" ", 20));
				mobile1.setFont(new Font(" ", 20));
				
				Button deleteCustomer1 = new Button("",delete);
				Button Back1 = new Button("",back1); 
				Button findCustomer = new Button("",find);
				
				TextField Tid1 = new TextField();
				TextField Tname1 = new TextField();
				TextField Taddress1 = new TextField();
				TextField Tmobile1 = new TextField();
				
				Tid1.setFont(new Font(" ", 20));
				Tname1.setFont(new Font(" ", 20));
				Taddress1.setFont(new Font(" ", 20));
				Tmobile1.setFont(new Font(" ", 20));
				
				HBox ID1 = new HBox(id1,Tid1);
				HBox Name1 = new HBox(name1,Tname1);
				HBox Address1 = new HBox(address1,Taddress1);
				HBox Mobile1 = new HBox(mobile1,Tmobile1);
				HBox clice1 = new HBox(findCustomer,deleteCustomer1,Back1);
				
				ID1.setAlignment(Pos.CENTER);
				Name1.setAlignment(Pos.CENTER);
				Address1.setAlignment(Pos.CENTER);
				Mobile1.setAlignment(Pos.CENTER);
				clice1.setAlignment(Pos.CENTER);
				
				ID1.setSpacing(72);
				Name1.setSpacing(37);
				Address1.setSpacing(20);
				Mobile1.setSpacing(30);
				clice1.setSpacing(70);
				
				VBox deletecust = new VBox(ID1,Name1,Address1,Mobile1,clice1);
				deletecust.setAlignment(Pos.CENTER);
				deletecust.setSpacing(15);
				
				Tid1.setDisable(false);
				Tname1.setDisable(true);
				Taddress1.setDisable(true);
				Tmobile1.setDisable(true);
				
				scene.setRoot(deletecust);
				
				findCustomer.setOnAction(f->{
					
					for(int i=0;i<mediaRental.customer.size();i++)
					{
						if (Tid1.getText().equals(mediaRental.customer.get(i).getID()))
						{
							Tname1.setText(mediaRental.customer.get(i).getName());
							Taddress1.setText(mediaRental.customer.get(i).getAddres());
							Tmobile1.setText(mediaRental.customer.get(i).getMobile());
						}
					}
				});
				
				deleteCustomer1.setOnAction(x->{
					
					for(int i=0;i<mediaRental.customer.size();i++)
					{
						if (Tid1.getText().equals(mediaRental.customer.get(i).getID()))
							mediaRental.customer.remove(i);
					}
					
					savingfile(mediaRental);
					
				});
				
				Back1.setOnAction(b->{
					scene.setRoot(order);
				});
				
			});
			
			UC.setOnAction(u->{
				
				ImageView update = new ImageView("https://img.icons8.com/nolan/344/approve-and-update.png");
				ImageView back2 = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView find2 = new ImageView("https://img.icons8.com/external-others-phat-plus/344/external-find-education-and-learning-blue-others-phat-plus.png");
				
				back2.setFitHeight(35);
				back2.setFitWidth(35);
				update.setFitHeight(35);
				update.setFitWidth(35);
				find2.setFitHeight(35);
				find2.setFitWidth(35);
				
				Label id2 = new Label("Customer ID:");
				Label name2 = new Label("Customer Name:");
				Label address2 = new Label("Customer Address:");
				Label mobile2 = new Label("Customer Mobile:");
				
				id2.setFont(new Font(" ", 20));
				name2.setFont(new Font(" ", 20));
				address2.setFont(new Font(" ", 20));
				mobile2.setFont(new Font(" ", 20));
				
				Button updateCustomer2 = new Button("",update);
				Button Back2 = new Button("",back2); 
				Button findCustomer2 = new Button("",find2);
				
				TextField Tid2 = new TextField();
				TextField Tname2 = new TextField();
				TextField Taddress2 = new TextField();
				TextField Tmobile2 = new TextField();
				
				Tid2.setFont(new Font(" ", 20));
				Tname2.setFont(new Font(" ", 20));
				Taddress2.setFont(new Font(" ", 20));
				Tmobile2.setFont(new Font(" ", 20));
				
				HBox ID2 = new HBox(id2,Tid2);
				HBox Name2 = new HBox(name2,Tname2);
				HBox Address2 = new HBox(address2,Taddress2);
				HBox Mobile2 = new HBox(mobile2,Tmobile2);
				HBox clice2 = new HBox(findCustomer2,updateCustomer2,Back2);
				
				ID2.setAlignment(Pos.CENTER);
				Name2.setAlignment(Pos.CENTER);
				Address2.setAlignment(Pos.CENTER);
				Mobile2.setAlignment(Pos.CENTER);
				clice2.setAlignment(Pos.CENTER);
				
				ID2.setSpacing(72);
				Name2.setSpacing(37);
				Address2.setSpacing(20);
				Mobile2.setSpacing(30);
				clice2.setSpacing(70);
				
				VBox updatecust = new VBox(ID2,Name2,Address2,Mobile2,clice2);
				updatecust.setAlignment(Pos.CENTER);
				updatecust.setSpacing(15);
				
				Tid2.setOnKeyTyped(dis->{
					
					Tid2.setDisable(false);
					Tname2.setDisable(false);
					Taddress2.setDisable(false);
					Tmobile2.setDisable(false);
					
				});
				
				Tname2.setOnKeyTyped(dis->{
					
					Tid2.setDisable(true);
					Tname2.setDisable(false);
					Taddress2.setDisable(false);
					Tmobile2.setDisable(false);
					
				});
				
				Taddress2.setOnKeyTyped(dis->{
					
					Tid2.setDisable(true);
					Tname2.setDisable(true);
					Taddress2.setDisable(false);
					Tmobile2.setDisable(false);
					
				});
				
				Tmobile2.setOnKeyTyped(dis->{
					
					Tid2.setDisable(true);
					Tname2.setDisable(true);
					Taddress2.setDisable(true);
					Tmobile2.setDisable(false);
					
				});
				
				scene.setRoot(updatecust);
				
				findCustomer2.setOnAction(f->{
					
					for(int i=0;i<mediaRental.customer.size();i++)
					{
						if (Tid2.getText().equals(mediaRental.customer.get(i).getID()))
						{
							Tname2.setText(mediaRental.customer.get(i).getName());
							Taddress2.setText(mediaRental.customer.get(i).getAddres());
							Tmobile2.setText(mediaRental.customer.get(i).getMobile());
						}
					}
					
					Tid2.setDisable(true);
					Tname2.setDisable(false);
					Taddress2.setDisable(false);
					Tmobile2.setDisable(false);
				});						
				
				updateCustomer2.setOnAction(p->{
					
					for(int i=0;i<mediaRental.customer.size();i++)
					{
						if (Tid2.getText().equals(mediaRental.customer.get(i).getID()))
						{
							mediaRental.customer.get(i).setName(Tname2.getText());
							mediaRental.customer.get(i).setAddres(Taddress2.getText());
							mediaRental.customer.get(i).setMobile(Tmobile2.getText());
						}
					}
					
					savingfile(mediaRental);
					
					Tid2.setText("");
					Tname2.setText("");
					Taddress2.setText("");
					Tmobile2.setText("");
					
					Tid2.setDisable(false);
					Tname2.setDisable(false);
					Taddress2.setDisable(false);
					Tmobile2.setDisable(false);
					
				});
				
				Back2.setOnAction(b->{
					scene.setRoot(order);
				});	
			});
			
			SBid.setOnAction(s->{
				
				ImageView search = new ImageView("https://img.icons8.com/fluency/344/search.png");
				ImageView back = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				
				search.setFitHeight(35);
				search.setFitWidth(35);
				back.setFitHeight(35);
				back.setFitWidth(35);
				
				Label id = new Label("Customer ID:");
				Label name = new Label("Customer Name:");
				Label address = new Label("Customer Address:");
				Label mobile = new Label("Customer Mobile:");
				
				id.setFont(new Font(" ", 20));
				name.setFont(new Font(" ", 20));
				address.setFont(new Font(" ", 20));
				mobile.setFont(new Font(" ", 20));
				
				Button searchCustomer = new Button("",search);
				Button Back = new Button("",back); 
				
				TextField Tid = new TextField();
				TextField Tname = new TextField();
				TextField Taddress = new TextField();
				TextField Tmobile = new TextField();
				
				Tid.setFont(new Font(" ", 20));
				Tname.setFont(new Font(" ", 20));
				Taddress.setFont(new Font(" ", 20));
				Tmobile.setFont(new Font(" ", 20));
				
				HBox ID = new HBox(id,Tid);
				HBox Name = new HBox(name,Tname);
				HBox Address = new HBox(address,Taddress);
				HBox Mobile = new HBox(mobile,Tmobile);
				HBox clice = new HBox(searchCustomer,Back);
				
				ID.setAlignment(Pos.CENTER);
				Name.setAlignment(Pos.CENTER);
				Address.setAlignment(Pos.CENTER);
				Mobile.setAlignment(Pos.CENTER);
				clice.setAlignment(Pos.CENTER);
				
				ID.setSpacing(72);
				Name.setSpacing(37);
				Address.setSpacing(20);
				Mobile.setSpacing(30);
				clice.setSpacing(70);
				
				VBox searchcust = new VBox(ID,Name,Address,Mobile,clice);
				searchcust.setAlignment(Pos.CENTER);
				searchcust.setSpacing(15);
				
				scene.setRoot(searchcust);
				
				Tid.setDisable(false);
				Tname.setDisable(true);
				Taddress.setDisable(true);
				Tmobile.setDisable(true);
				
				searchCustomer.setOnAction(c->{
					
					for(int i=0;i<mediaRental.customer.size();i++)
					{
						if (Tid.getText().equals(mediaRental.customer.get(i).getID()))
						{
							Tname.setText(mediaRental.customer.get(i).getName());
							Taddress.setText(mediaRental.customer.get(i).getAddres());
							Tmobile.setText(mediaRental.customer.get(i).getMobile());
						}
					}
					
					Tid.setDisable(true);
					Tname.setDisable(true);
					Taddress.setDisable(true);
					Tmobile.setDisable(true);
					
				});
				
				Back.setOnAction(b->{
					scene.setRoot(order);
				});
			});
			
			RM.setOnAction(r->{
				scene.setRoot(pane);
			});
		});
		
		mediaB.setOnAction(e->{
			
			Button ANM = new Button("Add new Media");
			Button DM = new Button("Delete Media");
			Button UM = new Button("Update Information about Media");
			Button SBcode = new Button("Search a Media by code");
			Button PAMI = new Button("Print All Media information");
			Button RM1 = new Button("Return to main page");
			
			ANM.setStyle("-fx-background-color: LightBlue");
			DM.setStyle("-fx-background-color: LightBlue");
			UM.setStyle("-fx-background-color: LightBlue");
			SBcode.setStyle("-fx-background-color: LightBlue");
			PAMI.setStyle("-fx-background-color: LightBlue");
			RM1.setStyle("-fx-background-color: LightBlue");
			
			ANM.setPrefSize(300, 40);
			DM.setPrefSize(300, 40);
			UM.setPrefSize(300, 40);
			SBcode.setPrefSize(300, 40);
			PAMI.setPrefSize(300, 40);
			RM1.setPrefSize(300, 40);
			
			VBox order1 = new VBox(ANM,DM,UM,SBcode,PAMI,RM1);
			order1.setSpacing(20);
			order1.setAlignment(Pos.CENTER);
			scene.setRoot(order1);
			
			ANM.setOnAction(a->{
				
				Label code = new Label("Media code: ");
				Label title = new Label("Media title: ");
				Label NOC = new Label("Number of copies: ");
				Label select = new Label("Select a media type: ");
				Label rating = new Label("Movie rating:");
				Label weight = new Label("Game weight:");
				Label artist = new Label("Album artist:");
				Label songs = new Label("Album Songs");
				
				TextField Tcode = new TextField();
				TextField Ttitle = new TextField();
				TextField TNOC = new TextField();
				TextField Trating = new TextField();
				TextField Tweight = new TextField();
				TextField Tartist = new TextField();
				TextField Tsongs = new TextField();
				
				ComboBox<String> BoxSelect = new ComboBox<String>();
				BoxSelect.setPromptText("SELECT");
				BoxSelect.getItems().addAll("Movie","Game","Album");
				
				GridPane Media = new GridPane ();
				
				Media.add(code, 0, 0);
				Media.add(Tcode, 1, 0);
				Media.add(title, 0, 1);
				Media.add(Ttitle, 1, 1);
				Media.add(NOC, 0, 2);
				Media.add(TNOC, 1, 2);
				Media.add(select, 0, 3);
				Media.add(BoxSelect, 1, 3);
				
				BoxSelect.setOnAction(s->{
					
					if(BoxSelect.getValue().equals("Movie"))
					{
						Media.add(rating, 0, 4);
						Media.add(Trating, 1, 4);
					}
					if(BoxSelect.getValue().equals("Game"))
					{
						Media.add(weight, 0, 4);
						Media.add(Tweight, 1, 4);
					}
					if(BoxSelect.getValue().equals("Album"))
					{
						Media.add(artist, 0, 4);
						Media.add(Tartist, 1, 4);
						Media.add(songs, 0, 5);
						Media.add(Tsongs, 1, 5);
					}
				});
				
				ImageView B = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView A = new ImageView("https://img.icons8.com/nolan/344/add.png");
				
				A.setFitHeight(35);
				A.setFitWidth(35);
				B.setFitHeight(35);
				B.setFitWidth(35);
				
				Button back = new Button("",B);
				Button add = new Button("",A);
				
				Media.add(back, 1, 6);
				Media.add(add, 0, 6);
				
				Media.setAlignment(Pos.CENTER);
				Media.setHgap(10);
				Media.setVgap(25);
				
				scene.setRoot(Media);
				
				Ttitle.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(false);
					TNOC.setDisable(false);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});
				
				TNOC.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(true);
					TNOC.setDisable(false);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});
				
				Trating.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(true);
					TNOC.setDisable(true);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});

				Tweight.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(true);
					TNOC.setDisable(true);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});
				
				Tartist.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(true);
					TNOC.setDisable(true);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});
				
				Tsongs.setOnKeyTyped(dis->{
					
					Tcode.setDisable(true);
					Ttitle.setDisable(true);
					TNOC.setDisable(true);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(true);
					Tsongs.setDisable(false);
					
				});
				
				add.setOnAction(ad->{
					
					if(BoxSelect.getValue().equals("Movie"))
						mediaRental.addMovie(Ttitle.getText(), Integer.parseInt(TNOC.getText()) , Trating.getText(), Tcode.getText());
					
					if(BoxSelect.getValue().equals("Game"))
						mediaRental.addGame(Ttitle.getText(), Integer.parseInt(TNOC.getText()), Double.parseDouble(Tweight.getText()), Tcode.getText());
					
					if(BoxSelect.getValue().equals("Album"))
						mediaRental.addAlbum(Ttitle.getText(), Integer.parseInt(TNOC.getText()), Tartist.getText(), Tsongs.getText(), Tcode.getText());
					
					savingfile(mediaRental);
					
					Tcode.setDisable(false);
					Ttitle.setDisable(false);
					TNOC.setDisable(false);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
					Tcode.setText("");
					Ttitle.setText("");
					TNOC.setText("");
					Trating.setText("");
					Tweight.setText("");
					Tartist.setText("");
					Tsongs.setText("");
					
				});
				
				back.setOnAction(b->{
					scene.setRoot(order1);
				});
				
			});
			
			DM.setOnAction(a->{
				
				Label code = new Label("Media code: ");
				Label title = new Label("Media title: ");
				Label NOC = new Label("Number of copies: ");
				Label select = new Label("Select a media type: ");
				Label rating = new Label("Movie rating:");
				Label weight = new Label("Game weight:");
				Label artist = new Label("Album artist:");
				Label songs = new Label("Album Songs");
				
				TextField Tcode = new TextField();
				TextField Ttitle = new TextField();
				TextField TNOC = new TextField();
				TextField Trating = new TextField();
				TextField Tweight = new TextField();
				TextField Tartist = new TextField();
				TextField Tsongs = new TextField();
				
				GridPane Media = new GridPane ();
				
				Media.add(code, 0, 0);
				Media.add(Tcode, 1, 0);
				Media.add(title, 0, 1);
				Media.add(Ttitle, 1, 1);
				Media.add(NOC, 0, 2);
				Media.add(TNOC, 1, 2);
				
				ImageView B = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView D = new ImageView("https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-delete-multimedia-kiranshastry-gradient-kiranshastry.png");
				ImageView S = new ImageView("https://img.icons8.com/fluency/344/search.png");
				
				D.setFitHeight(35);
				D.setFitWidth(35);
				B.setFitHeight(35);
				B.setFitWidth(35);
				S.setFitHeight(35);
				S.setFitWidth(35);
				
				Button back = new Button("",B);
				Button delete = new Button("",D);
				Button search = new Button("",S);
				
				Media.add(back, 2, 6);
				Media.add(delete, 1, 6);
				Media.add(search, 0, 6);
				
				Media.setAlignment(Pos.CENTER);
				Media.setHgap(15);
				Media.setVgap(25);
				
				scene.setRoot(Media);
				
				Tcode.setDisable(false);
				Ttitle.setDisable(true);
				TNOC.setDisable(true);
				Trating.setDisable(true);
				Tweight.setDisable(true);
				Tartist.setDisable(true);
				Tsongs.setDisable(true);
					
				search.setOnAction(s->{
					
					for(int i=0;i<mediaRental.media.size();i++)
					{
						if(Tcode.getText().equals(mediaRental.media.get(i).getCode()))
						{
							Ttitle.setText(mediaRental.media.get(i).getTitle());
							TNOC.setText(Integer.toString(mediaRental.media.get(i).getNOC()));
							
							if (mediaRental.media.get(i) instanceof Movie)
							{
								Trating.setText(((Movie)mediaRental.media.get(i)).getRating());
							}
							
							if (mediaRental.media.get(i) instanceof Game)
							{
								Tweight.setText(Double.toString(((Game)mediaRental.media.get(i)).getWeight())); 
							}
							
							if (mediaRental.media.get(i) instanceof Album)
							{
								Tartist.setText(((Album)mediaRental.media.get(i)).getArtist());
								Tsongs.setText(((Album)mediaRental.media.get(i)).getSong());
							}
							
							if (mediaRental.media.get(i) instanceof Movie)
							{
								Media.add(rating, 0, 3);
								Media.add(Trating, 1, 3);
							}
							
							if (mediaRental.media.get(i) instanceof Game)
							{
								Media.add(weight, 0, 3);
								Media.add(Tweight, 1, 3);
							}
							
							if (mediaRental.media.get(i) instanceof Album)
							{
								Media.add(artist, 0, 3);
								Media.add(Tartist, 1, 3);
								Media.add(songs, 0, 4);
								Media.add(Tsongs, 1, 4);
							}
						}
					}
				});
				
				delete.setOnAction(d->{
					
					for (int i =0;i<mediaRental.media.size();i++)
					{
						if (mediaRental.media.get(i).getCode().equals(Tcode.getText()))
						{
							mediaRental.media.remove(i);
						}
					}
					
					savingfile(mediaRental);
					
					Tcode.setText("");
					Ttitle.setText("");
					TNOC.setText("");
					Trating.setText("");
					Tweight.setText("");
					Tartist.setText("");
					Tsongs.setText("");
					
				});
				
				back.setOnAction(b->{
					scene.setRoot(order1);
				});	
			});
			
			UM.setOnAction(u->{
				
				Label code = new Label("Media code: ");
				Label title = new Label("Media title: ");
				Label NOC = new Label("Number of copies: ");
				Label select = new Label("Select a media type: ");
				Label rating = new Label("Movie rating:");
				Label weight = new Label("Game weight:");
				Label artist = new Label("Album artist:");
				Label songs = new Label("Album Songs");
				
				TextField Tcode = new TextField();
				TextField Ttitle = new TextField();
				TextField TNOC = new TextField();
				TextField Trating = new TextField();
				TextField Tweight = new TextField();
				TextField Tartist = new TextField();
				TextField Tsongs = new TextField();
				
				GridPane Media = new GridPane ();
				
				Media.add(code, 0, 0);
				Media.add(Tcode, 1, 0);
				Media.add(title, 0, 1);
				Media.add(Ttitle, 1, 1);
				Media.add(NOC, 0, 2);
				Media.add(TNOC, 1, 2);
				
				ImageView B = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView U = new ImageView("https://img.icons8.com/nolan/344/approve-and-update.png");
				ImageView S = new ImageView("https://img.icons8.com/fluency/344/search.png");
				
				U.setFitHeight(35);
				U.setFitWidth(35);
				B.setFitHeight(35);
				B.setFitWidth(35);
				S.setFitHeight(35);
				S.setFitWidth(35);
				
				Button back = new Button("",B);
				Button ubdate = new Button("",U);
				Button search = new Button("",S);
				
				Media.add(back, 2, 6);
				Media.add(ubdate, 1, 6);
				Media.add(search, 0, 6);
				
				Media.setAlignment(Pos.CENTER);
				Media.setHgap(10);
				Media.setVgap(25);
				
				scene.setRoot(Media);
				
				search.setOnAction(s->{
					
					for(int i=0;i<mediaRental.media.size();i++)
					{
						if(Tcode.getText().equals(mediaRental.media.get(i).getCode()))
						{
							Ttitle.setText(mediaRental.media.get(i).getTitle());
							TNOC.setText(Integer.toString(mediaRental.media.get(i).getNOC()));
							
							if (mediaRental.media.get(i) instanceof Movie)
							{
								Trating.setText(((Movie)mediaRental.media.get(i)).getRating());
							}
							
							if (mediaRental.media.get(i) instanceof Game)
							{
								Tweight.setText(Double.toString(((Game)mediaRental.media.get(i)).getWeight())); 
							}
							
							if (mediaRental.media.get(i) instanceof Album)
							{
								Tartist.setText(((Album)mediaRental.media.get(i)).getArtist());
								Tsongs.setText(((Album)mediaRental.media.get(i)).getSong());
							}
							
							if (mediaRental.media.get(i) instanceof Movie)
							{
								Media.add(rating, 0, 3);
								Media.add(Trating, 1, 3);
							}
							
							if (mediaRental.media.get(i) instanceof Game)
							{
								Media.add(weight, 0, 3);
								Media.add(Tweight, 1, 3);
							}
							
							if (mediaRental.media.get(i) instanceof Album)
							{
								Media.add(artist, 0, 3);
								Media.add(Tartist, 1, 3);
								Media.add(songs, 0, 4);
								Media.add(Tsongs, 1, 4);
							}
						}
					}
					
					Tcode.setDisable(true);
					Ttitle.setDisable(false);
					TNOC.setDisable(false);
					Trating.setDisable(false);
					Tweight.setDisable(false);
					Tartist.setDisable(false);
					Tsongs.setDisable(false);
					
				});
				
				ubdate.setOnAction(Upd->{
					
					for (int i=0;i<mediaRental.media.size();i++)
					{
						if (mediaRental.media.get(i).getCode().equals(Tcode.getText()))
						{
							mediaRental.media.get(i).setTitle(Ttitle.getText());
							mediaRental.media.get(i).setNOC(Integer.parseInt(TNOC.getText()));
							
							if (mediaRental.media.get(i) instanceof Movie)
							{
								((Movie)mediaRental.media.get(i)).setRating(Trating.getText());
							}
							
							if (mediaRental.media.get(i) instanceof Game)
							{
								((Game)mediaRental.media.get(i)).setWeight(Double.parseDouble(Tweight.getText()));
							}
							
							if (mediaRental.media.get(i) instanceof Album)
							{
								((Album)mediaRental.media.get(i)).setArtist(Tartist.getText());
								((Album)mediaRental.media.get(i)).setSong(Tsongs.getText());
							}							
						}
					}
					
					savingfile(mediaRental);
					
					Tcode.setText("");
					Ttitle.setText("");
					TNOC.setText("");
					Trating.setText("");
					Tweight.setText("");
					Tartist.setText("");
					Tsongs.setText("");
					
				});
				
				back.setOnAction(b->{
					scene.setRoot(order1);
				});
				
			});
			
			SBcode.setOnAction(s->{
				
				ImageView search = new ImageView("https://img.icons8.com/fluency/344/search.png");
				ImageView B = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				
				search.setFitHeight(35);
				search.setFitWidth(35);
				B.setFitHeight(35);
				B.setFitWidth(35);
				
				Button BS = new Button("",search);
				Button BB = new Button("",B);
				
				Label code = new Label("Media Code:");
				TextField Tcode = new TextField();
				
				TextArea Tinfo = new TextArea();
				
				GridPane SMedia = new GridPane ();
				
				SMedia.add(code, 0, 0);
				SMedia.add(Tcode, 1, 0);
				SMedia.add(Tinfo, 1, 1);
				SMedia.add(BS, 1, 2);
				SMedia.add(BB, 2, 2);
				
				SMedia.setAlignment(Pos.CENTER);
				SMedia.setHgap(10);
				SMedia.setVgap(25);
				
				scene.setRoot(SMedia);
				
				BS.setOnAction(so->{
					
					for (int i=0;i<mediaRental.media.size();i++)
					{
						if (mediaRental.media.get(i).getCode().equals(Tcode.getText()))
						{
							if (mediaRental.media.get(i) instanceof Movie)
							{
								Tinfo.setText(((Movie)mediaRental.media.get(i)).toString());
							}
							if (mediaRental.media.get(i) instanceof Album)
							{
								Tinfo.setText(((Album)mediaRental.media.get(i)).toString());
							}
							if (mediaRental.media.get(i) instanceof Game)
							{
								Tinfo.setText(((Game)mediaRental.media.get(i)).toString());
							}
						}
					}
					
				});
				
				BB.setOnAction(b->{
					scene.setRoot(order1);
				});
			});
			
			PAMI.setOnAction(p->{
				
				ImageView B = new ImageView("https://img.icons8.com/external-vitaliy-gorbachev-flat-vitaly-gorbachev/344/external-back-arrow-arrows-vitaliy-gorbachev-flat-vitaly-gorbachev.png");
				ImageView P = new ImageView("https://img.icons8.com/office/344/print.png");
				
				B.setFitHeight(35);
				B.setFitWidth(35);
				P.setFitHeight(35);
				P.setFitWidth(35);
				
				Button BB = new Button("",B);
				Button BP = new Button("",P);
				
				Label mediaInfo = new Label("All Media information: ");
				TextArea TmediaInfo = new TextArea();
				
				mediaInfo.setFont(new Font(" ", 30));
				
				HBox info = new HBox(mediaInfo,TmediaInfo);
				HBox Binfo = new HBox(BP,BB);
				VBox all = new VBox(info,Binfo);
				
				info.setAlignment(Pos.CENTER);
				Binfo.setAlignment(Pos.CENTER);
				all.setAlignment(Pos.CENTER);
				
				info.setSpacing(40);
				Binfo.setSpacing(99);
				all.setSpacing(80);
				
				scene.setRoot(all);
				
				BP.setOnAction(print->{
					
					TmediaInfo.setText(mediaRental.getAllMediaInfo());
					
					savingfile(mediaRental);
					
				});
				
				BB.setOnAction(b->{
					scene.setRoot(order1);
				});
			});
			
			RM1.setOnAction(r->{
				scene.setRoot(pane);
			});
		});
		
		rentB.setOnAction(e->{
			
			Label CID = new Label("All Media information: ");
			Label Mcode = new Label("All Media information: ");
			Label Rdate = new Label("All Media information: ");
			
			CID.setFont(new Font(" ", 20));
			Mcode.setFont(new Font(" ", 20));
			Rdate.setFont(new Font(" ", 20));
			
			TextField TCID =new TextField();
			TextField TMcode =new TextField();
			TextField TRdate =new TextField();
			
			TCID.setMaxWidth(100);
			TMcode.setMaxWidth(100);
			TRdate.setMaxWidth(100);
			
			TextArea customerInfo = new TextArea();
			TextArea mediaInfo = new TextArea();
			
			Button addB = new Button("Add To cart");
			Button removeB = new Button("Remove from cart");
			Button processB = new Button("Process Cart");
			Button backB = new Button("Back");
			
			addB.setFont(new Font(" ", 15));
			removeB.setFont(new Font(" ", 15));
			processB.setFont(new Font(" ", 15));
			backB.setFont(new Font(" ", 15));
			
			GridPane RentPane = new GridPane();
			HBox RentPaneB  = new HBox(addB,removeB,processB);
			
			RentPane.add(CID, 0, 0);
			RentPane.add(TCID, 1, 0);
			RentPane.add(customerInfo, 1, 1);
			RentPane.add(Mcode, 0, 2);
			RentPane.add(TMcode, 1, 2);
			RentPane.add(mediaInfo, 1, 3);
			RentPane.add(Rdate, 0, 4);
			RentPane.add(TRdate, 1, 4);
			RentPane.add(RentPaneB, 1, 5);
			RentPane.add(backB, 2, 5);
			
			RentPane.setAlignment(Pos.CENTER);
			RentPane.setHgap(20);
			RentPane.setVgap(35);
			RentPaneB.setSpacing(15);
			
			scene.setRoot(RentPane);
			
			
			
			addB.setOnAction(add->{
				
				for(int i=0;i<mediaRental.customer.size();i++)
				{
					if (mediaRental.customer.get(i).getID().equals(TCID.getText()))
					{
						customerInfo.setText(mediaRental.customer.get(i).toString());
					}
				}
				
				for (int i=0;i<mediaRental.media.size();i++)
				{
					if(mediaRental.media.get(i).getCode().equals(TMcode.getText()))
					{
						if (mediaRental.media.get(i) instanceof Movie)
						{
							mediaInfo.setText(((Movie)mediaRental.media.get(i)).toString());
						}
						if (mediaRental.media.get(i) instanceof Album)
						{
							mediaInfo.setText(((Album)mediaRental.media.get(i)).toString());
						}
						if (mediaRental.media.get(i) instanceof Game)
						{
							mediaInfo.setText(((Game)mediaRental.media.get(i)).toString());
						}
					}
				}
				
				mediaRental.addToCart(TCID.getText(), TMcode.getText());
				
				String day = "M/d/y" ;	
//				DateFormat DF = new SimpleDateFormat(day);
//				Date date = Calendar.getInstance().getTime();
//				String dateASstring = DF.format(date);
				
				Date d = new Date();
				
				day = d.toGMTString();
				
				TRdate.setText(day);
				
				savingfile(mediaRental);
				
			});
			
			removeB.setOnAction(r->{
				
				for(int i=0;i<mediaRental.customer.size();i++)
				{
					if (mediaRental.customer.get(i).getID().equals(TCID.getText()))
					{
						customerInfo.setText(mediaRental.customer.get(i).toString());
					}
				}
				
				for (int i=0;i<mediaRental.media.size();i++)
				{
					if(mediaRental.media.get(i).getCode().equals(TMcode.getText()))
					{
						if (mediaRental.media.get(i) instanceof Movie)
						{
							mediaInfo.setText(((Movie)mediaRental.media.get(i)).toString());
						}
						if (mediaRental.media.get(i) instanceof Album)
						{
							mediaInfo.setText(((Album)mediaRental.media.get(i)).toString());
						}
						if (mediaRental.media.get(i) instanceof Game)
						{
							mediaInfo.setText(((Game)mediaRental.media.get(i)).toString());
						}
					}
				}
				
				mediaRental.removeFromCart(TCID.getText(), TMcode.getText());
				
				String day = "M/d/y" ;	
				DateFormat DF = new SimpleDateFormat(day);
				Date date = Calendar.getInstance().getTime();
				String dateASstring = DF.format(date);
				
				TRdate.setText(dateASstring);
				
				savingfile(mediaRental);
				
			});
			
			processB.setOnAction(pr->{
				
				mediaRental.processRequests();
				
				String day = "M/d/y" ;	
				DateFormat DF = new SimpleDateFormat(day);
				Date date = Calendar.getInstance().getTime();
				String dateASstring = DF.format(date);
				
				TRdate.setText(dateASstring);
				
				savingfile(mediaRental);
				
			});
			
			backB.setOnAction(b->{
				scene.setRoot(pane);
			});
		});
		
		savingfile(mediaRental);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static void savingfile (MediaRental mediaRental) {
		
		try {
			FileWriter f= new FileWriter("customer.txt");
			FileWriter f2= new FileWriter("media.txt");
			FileWriter f3= new FileWriter("cart.txt");
			FileWriter f4= new FileWriter("rent.txt");
			f.append(mediaRental.getAllCustomersInfo());
			f2.write(mediaRental.getAllMediaInfo());
			for(int j=0;j<mediaRental.getCustomer().size(); j++) {
				for(int k=0; k<mediaRental.getCustomer().get(j).getCart().size(); k++) {
		         	f3.write(mediaRental.getCustomer().get(j).getID()  +":"+ mediaRental.getCustomer().get(j).getCart().get(k)+"\n");
		         	System.out.println(mediaRental.getCustomer().get(j).getID() +":"+ mediaRental.getCustomer().get(j).getCart().get(k)+"\n");
				}
				for(int k=0; k<mediaRental.getCustomer().get(j).getRent().size(); k++)
		         	f4.write(mediaRental.getCustomer().get(j).getID() +":"+ mediaRental.getCustomer().get(j).getRent().get(k)+"\n");
			}
			f.close();
			f2.close();
			f3.close();
			f4.close();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private static boolean readingCustomer (MediaRental mediaRental)
	{
		String[] in = new String[5] ;
		String line ;
		File file = new File ("customer.txt");
		if (file.length() == 0 )
            return false;
        else
        {
        	Scanner inFile;
    		try {
    			inFile = new Scanner (file);
    			while(inFile.hasNextLine()) {
    				line= inFile.nextLine();
    				if (line.length() == 0)
        				return false;
    				in[0] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    				line = line.substring(line.indexOf(',')+1);
    				
    				in[1] = line.substring((line.indexOf('=')+1), line.indexOf(','));
    				line = line.substring(line.indexOf(',')+1);
    				
    				in[2] = line.substring((line.indexOf('=')+1), line.indexOf(','));
    				line = line.substring(line.indexOf(',')+1);
    				
    				in[3] = line.substring((line.indexOf('=')+1), line.indexOf(','));
    				line = line.substring(line.indexOf(',')+1);
    				
    				in[4] = line.substring(line.indexOf('=')+1, (line.length()-1));
    				
    				mediaRental.addCustomer(in[0], in[1], in[2], in[3], in[4]);
    			}
    			
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        }
		return true;
	}
	
	private static boolean readingMedia (MediaRental mediaRental)
	{
		String[] in = new String[5] ;
		String line ;
		File file = new File ("media.txt");
		if (file.length() == 0)
            return false;
        else {
        	Scanner inFile;
    		try {
    			inFile = new Scanner (file);
    			while(inFile.hasNextLine()) {
    				line= inFile.nextLine();
    				if (line.length() == 0)
        				return false;
    				if (line.charAt(0) == 'M')
    				{
    					in[0] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[1] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[2] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[3] = line.substring(line.indexOf('=')+1, (line.length()-1));
    					
    					mediaRental.addMovie(in[0], Integer.parseInt(in[1]), in[2], in[3]);
    				}
    				
    				if (line.charAt(0) == 'A')
    				{
    					in[0] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[1] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[2] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[3] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[4] = line.substring(line.indexOf('=')+1, (line.length()-1));
    					
    					mediaRental.addAlbum(in[0], Integer.parseInt(in[1]), in[2], in[3], in[4]);
    				}
    				
    				if (line.charAt(0) == 'G')
    				{
    					in[0] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[1] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[2] = line.substring(line.indexOf('=')+1, line.indexOf(','));
    					line = line.substring(line.indexOf(',')+1);
    					
    					in[3] = line.substring(line.indexOf('=')+1, (line.length()-1));
    					
    					mediaRental.addGame(in[0], Integer.parseInt(in[1]) , Double.parseDouble(in[2]) , in[3]);
    				}
    			}
    			
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        }
		return true;
	}
	
	private static boolean readingCart (MediaRental mediaRental)
	{
		String[] in = new String[2] ;
		String line ;
		File file = new File ("cart.txt");
		if (file.length() == 0)
            return false;
        else {
        	Scanner inFile;;
    		try {
    			inFile = new Scanner (file);
    			while(inFile.hasNextLine()) {
    				line= inFile.nextLine();
    				if (line.length() == 0)
        				return false;
    				in = line.split(":");
    				mediaRental.addToCart(in[0], in[1]);
    			}
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        }
		return true;
	}
	
	private static boolean readingRent (MediaRental mediaRental)
	{
		String[] in = new String[2] ;
		String line ;
		File file = new File ("rent.txt");
		if (file.length() == 0)
            return false;
        else {
        	Scanner inFile;;
    		try {
    			inFile = new Scanner (file);
    			while(inFile.hasNextLine()) {
    				line= inFile.nextLine();
    				if (line.length() == 0)
        				return false;
    				in = line.split(":");
    				for (int j=0;j<mediaRental.customer.size();j++)
    				{
    					if (mediaRental.customer.get(j).getID().equals(in[0]))
    						mediaRental.customer.get(j).getRent().add(in[1]);
    				}
    			}
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        }
        return true;
	}
	
}
