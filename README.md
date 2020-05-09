# PayPalProject

### Idea behind this project
I share subscriptions to services to things like Netflix and Family Spotify. Idealy, subscriptions that are setup to use multiple accounts under one family plan. An idea situation of this is just a family where the kids have grown up to a point where they are expected to chip into the cost for Netflix.
While the parents, or just the owners of a plan, can just manually Venmo their kids, much like mine does for my phone bill (thanks mom), a better and more stream-line option would just be to create a subscription of your own.

### Eventually
By using this application, you will be able to do two things. Create automatic invoices and send them out to a list of people with the press of a button. This will act as a simple Batch Invoice creator. Another flow of this application will be to create subscription models that you can then send to your friends to have them subscribe to your own plan and have a steady flow of money.
The price of these models can be explicitly defined per person via a template, or split the cost of a plan across the number of payees that are signed up.

## How to use
test
### PayPal Business Account
As it stands, you cannot leverage the PayPal API without making your PayPal account a business account. When that is done, you will have the option to go to https://developer.paypal.com to create an API application and you will be provided a ClientID and ClientSecret. You will also have to jump through another hoop to verify your Business Account to make use of the Live API, where you will recieve new ID's and Sercret's that are particular to that Live environment. Once you have those, you will be able to use those as your login to this application and have paymets and items sent to your account.
