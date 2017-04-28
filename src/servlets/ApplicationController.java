package servlets;

import beans.Client;

public class ApplicationController {
static Client client=null;

public static Client getClient() {
	return client;
}

public static void setClient(Client client) {
	ApplicationController.client = client;
}

}
