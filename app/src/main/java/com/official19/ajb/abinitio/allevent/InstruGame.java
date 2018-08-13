package com.official19.ajb.abinitio.allevent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.instru;

public class InstruGame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    CardView RulesCard, PrizeCard, Co_OrdinatorCard;
    TextView Description,RulesCardHidden, PrizeCardHidden, Co_OrdinatorCardHidden;
    ImageView RulesArrow,PrizeArrow,Co_OrdinatorArrow;
    FloatingActionButton makeCall;
    String cordintor_no, descb0, descb1, descb2, descb3,
            rulesCardHidden0, rulesCardHidden1, rulesCardHidden2, rulesCardHidden3,
            prizeCardHidden0, prizeCardHidden1, prizeCardHidden2, prizeCardHidden3,
            co_OrdinatorCardHidden0, co_OrdinatorCardHidden1, co_OrdinatorCardHidden2, co_OrdinatorCardHidden3;
    ImageView event_logo;

    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUI();

        setSupportActionBar(toolbar);

        Intent intent =getIntent();
        String event = intent.getStringExtra("Instru_Event");

        getSupportActionBar().setTitle(event);

        completeMechanical();

        switch (event)
        {
            case "Robosoccer":
                Description.setText(descb0);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:7719896954";
                break;

            case "PLC Master":
                Description.setText(descb1);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:8796540953";
                break;

            case "Quiz":
                Description.setText(descb2);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:7028573584";
                break;

            case "Block Warrior":
                Description.setText(descb3);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
                cordintor_no="tel:9405902883";
                break;

        }


        ExpandCard();

        setMakeCall();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(this, instru.class));
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        MainActivity.navigation(this ,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    void setUI(){
        RulesCard = (CardView)findViewById(R.id.cvRulesCard);
        PrizeCard = (CardView)findViewById(R.id.cvPrizeCard);
        Co_OrdinatorCard = (CardView)findViewById(R.id.cvCo_ordinatorCard);

        Description=(TextView)findViewById(R.id.tvDescriptionGame);
        RulesCardHidden = (TextView) findViewById(R.id.tvRulesHidden);
        PrizeCardHidden = (TextView) findViewById(R.id.tvPrizeHidden);
        Co_OrdinatorCardHidden = (TextView) findViewById(R.id.tvCo_ordinatorHidden);

        event_logo=(ImageView)findViewById(R.id.imageGame);

        RulesArrow=(ImageView)findViewById(R.id.ivArrowRules);
        PrizeArrow=(ImageView)findViewById(R.id.ivArrowPrizes);
        Co_OrdinatorArrow=(ImageView)findViewById(R.id.ivArrowCordinator);

        makeCall = findViewById(R.id.call);

    }

    void ExpandCard(){

        RulesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(RulesCardHidden.getVisibility() == view.VISIBLE){
                    RulesCardHidden.setVisibility(view.GONE);
                    RulesArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    RulesCardHidden.setVisibility(view.VISIBLE);
                    RulesArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

        PrizeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PrizeCardHidden.getVisibility() == view.VISIBLE){
                    PrizeCardHidden.setVisibility(view.GONE);
                    PrizeArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    PrizeCardHidden.setVisibility(view.VISIBLE);
                    PrizeArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

        Co_OrdinatorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Co_OrdinatorCardHidden.getVisibility() == view.VISIBLE){
                    Co_OrdinatorCardHidden.setVisibility(view.GONE);
                    Co_OrdinatorArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    Co_OrdinatorCardHidden.setVisibility(view.VISIBLE);
                    Co_OrdinatorArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

    }

    void setMakeCall(){
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);//USE ACTION_DIAL
                callIntent.setData(Uri.parse(cordintor_no));
                if (ContextCompat.checkSelfPermission(InstruGame.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(InstruGame.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                }
                else
                {
                    startActivity(callIntent);
                }
            }
        });
    }

    void completeMechanical(){
        //
        descb0 = "-You might have created your own player when you play FIFA. \n" +
                "-Now try this out in the real world by creating your own robot and score as much as you can. \n" +
                "-In Robo-soccer, two teams will play a match of football against each other using a manual bot. ";

        descb2 = "• Quiz competition is a pursuit of trivial knowledge, encourage students to improve their knowledge and their awareness of the world around them. Welcome to the Engineers quiz. ";

        descb3= "• Terms have to make manual bot.\n" +
                "• Manual bot has to clear the way by transferring the block into specific zone. But need to tackle other obstacle.";

        descb1= "• PLC is the main controller in process industries in the participants will gain in-depth knowledge and experience in programming &application of PLC.";

        //
        rulesCardHidden0 = "-7 min match with 3 min half and 1minbreak. \n" +
                "-Each Goal will carry 10points. \n" +
                "-Each bot has to score goals from his opponents half or the goal will not be counted. \n" +
                "\n" +
                "\n" +
                "ROUNDS:  \n" +
                "                1 Elimination Round \n" +
                "                2 Quarterfinal \n" +
                "                3 Semi-final \n" +
                "                4 Final \n" +
                "\n" +
                "\n" +
                "RULES: \n" +
                "    • Max. 16 top scorer teams will be selected from first round. \n" +
                "    • Max. 12 volt dc power supply will be provided. \n" +
                "    • If any technical fault occurs, then that team will be given maximum of 2 min for recovery. There are no other timeouts in the game. \n" +
                "    • A bot having dimensions more than the specified dimensions will be disqualified. \n" +
                "    • During the match if there is any type of interruption, then match will be started from neutral points as given in arena (there are 4 neutral points). \n" +
                "    • In case of tie, the game will be played by golden goal. Golden goal – time limit 1min. bot scoring first goal will be winner. (All rules will be considered strictly) \n" +
                " \n" +
                "VIOLATION:- \n" +
                "    -2 points will be deducted any kind of damage to the Arena. \n" +
                "    -3 points will be deducted for grabbing or lifting the ball. \n" +
                "    -5 points will be deducted for any intentional damage to the opponent’s bot. \n" +
                " \n" +
                "DIMENSIONS: \n" +
                "    • Bot-25×25×25 cm (initial) \uF0B7\n Weight- up to 5 kg. \n" +
                "   \n" +
                "NOTE: \n" +
                "Decision taken by the coordinator will be final. \n" +
                " \n" +
                "TEAM MEMBERS- Max. 3 \n" +
                " \n" +
                "\n" +
                "ENTRY FEE:  RS.200/ team ";

        rulesCardHidden2 = "\n" +
                "    • There will be 3 rounds. \n" +
                "    • Round 1: MCQ test – 50 questions based on historic, geographic, general science, basic mathematics and English have to be solve in 30 minutes. \n" +
                "    • Round2: Aptitude – 25 questions based on intelligence and grammar & Engineering has to be solved in 30 minutes. \n" +
                "    • Round3: Rapid Fire Round \n" +
                "    • No mobile phones or calculator will be allowed. \n" +
                "    • Changes may be there with respect to the subjects. \n" +
                "NOTE: \n" +
                "Decision taken by the coordinator will be final. \n" +
                "TEAM MEMBERS- Max. 2 \n" +
                " \n" +
                "ENTRY FEE: \n" +
                "Team of 1 = Rs.100  \n" +
                "Team of 2 -Rs.150";

        rulesCardHidden3 = "Rules:\n" +
                "1. It is an task completion race on arena\n" +
                "2. weight of bot must be 5kg.\n" +
                "3. 12 volt power supply will be provided.\n" +
                "4. A team should contain only two members.\n" +
                "    • Operator\n" +
                "    • Instructor\n" +
                "5. Any technical fault during the match will not be accepted and that team has to continue the game.\n" +
                "6. A bot having dimension more than the specified dimension will not be allowed to play.\n" +
                "\n" +
                "Dimensions:\n" +
                "1. Bot: 25cmX25cmX25cm (lxbxh)\n" +
                "2. Block: 12cmX12cmX12cm (lxbxh)\n" +
                "\n" +
                "Arena:\n" +
                "Arena will be displayed on spot.\n" +
                "\n" +
                "Judging criteria :\n" +
                "Instruction about judging criteria will be given on spot\n" +
                "\n" +
                "NOTE: Team Member-max 2.";

        rulesCardHidden1 = "ROUND 1:\n" +
                "    • the first round includes the test which consists of 30 multiple choice questions based on microcontrollers and embedded systems.\n" +
                "    • Each question will be for one point.\n" +
                "    • Number of teams selected for the second round will be based upon total number of teams registered.\n" +
                "\n" +
                "ROUND 2:\n" +
                "    • In this round we will give a 5 basic problem statement for programme solving.\n" +
                "    • If the two teams have same points then the task completion time will be considered.\n" +
                "    • The team which complete the task will be eligible for final Round.\n" +
                "\n" +
                "\n" +
                "ROUND 3:\n" +
                "    • In this round the finalist has to solve a problem statement on WPL software and simulate it on this application.\n" +
                "    • Based on the performance the winner will be selected.\n" +
                "\n" +
                "SYLLABUS:\n" +
                "    1. PLC Basics.\n" +
                "    2. Instruction set.\n" +
                "    3. I/O power ratings.\n" +
                "    4. Relay logic.\n" +
                "    5. Real time applications.\n" +
                "\n" +
                "SOFTWARE VERSIONS:\n" +
                "    1. WPL Soft (Delta PLC)\n" +
                "    2. Allen Bradley software (If it is available)\n" +
                "(Rx logix 500)\n" +
                "\n" +
                "NOTE: If you have any query regarding software then our volunteer will help you.\n" +
                "\n" +
                "ELLIGIBILITY:\n" +
                "All students with a valid identity card of their respective educational Institutes are eligible to participate in the event.\n" +
                "\n" +
                "\n" +
                "TEAM SPECIFICATIONS:\n" +
                "A team may consist of 2 members students from different educational institutions can form a team.\n" +
                "\n" +
                "ENTRY FEE:\n" +
                "₹ 100 Per Team(Max 2 members)";

        prizeCardHidden0 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden1 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden2 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden3 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";

        co_OrdinatorCardHidden0 = "Rohit Sirsat\n" +
                "\trohitshirsat29@gmail.com\n" +
                "\tMobile no:-7719896954\n";

        co_OrdinatorCardHidden1 = "Pratik Yadav\n" +
                "\tyadavpratik702@gmail.com\n" +
                "\tMobile no:-8796540953\n";

        co_OrdinatorCardHidden2 = "Pooja Gaikwad\n" +
                "\tpoojagaikwad5757@gmail.com\n" +
                "\tMobile no:-7028573584\n";

        co_OrdinatorCardHidden3 = "Ashutosh Kamble\n" +
                "\tav.kamble27@gmail.com\n" +
                "\tMobile no:-9405902883\n";
    }
}
