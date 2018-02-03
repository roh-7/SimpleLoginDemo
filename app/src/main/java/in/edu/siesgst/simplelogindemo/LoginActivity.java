package in.edu.siesgst.simplelogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity
{
	final static String LOG_TAG = LoginActivity.class.getSimpleName();

	EditText email,password;
	Button login;

	StringRequest request;
	RequestQueue queue;

	String url = "http://starlord.hackerearth.com/studio";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		email = (EditText) findViewById(R.id.email_edit);
		password = (EditText) findViewById(R.id.pass_edit);
		login = (Button) findViewById(R.id.login);

		queue = Volley.newRequestQueue(this);

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				String emailEntered = email.getText().toString();
				String passwordEntered = password.getText().toString();
				auth(emailEntered,passwordEntered);
			}
		});
	}

	public void auth(String emailEntered, String passwordEntered)
	{
		request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
		{
			@Override
			public void onResponse(String response)
			{
				Log.v(LOG_TAG,response);
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error)
			{
				Log.v(LOG_TAG,error.toString());
			}
		});
		queue.add(request);
	}

}
