package individualFinance.saveLoad;

import individualFinance.settings.Settings;

import jakarta.xml.bind.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SaveLoad {

	public static void load(Users users){
		try {
			JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			UsersWrapper wr = (UsersWrapper) um.unmarshal(new FileInputStream(Settings.getFileSave()));
			Users.getInstance().setUsers(wr.getUsers());
		}catch (FileNotFoundException | JAXBException e) {
			System.out.println("файл не существует");
		}
	}

	public static void save(Users users){
		try {
			JAXBContext context = JAXBContext.newInstance(UsersWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			UsersWrapper wrapper = new UsersWrapper();
			wrapper.setUsers(Users.getInstance().getUsers());
			m.marshal(wrapper, Settings.getFileSave());
			m.marshal((wrapper), Settings.getFileSave());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
