import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class SqlGenerator {

    public static void main(String[] args) {

//        String free = "Upto 3 published jobs,Upto 50 employees,Basic Career Site,Email Integration,Kanban Boards for applicant tracking,Team Collaboration,Candidate Application via Email,Employee Referral,Employee Directory,Organization chart,Mobile apps (iOS and Android),Basic Time Off Management,Payroll Management";
//        String growth = "Upto 20 published jobs,Unlimited employees,Customizable applicant form,Custom Interview Scorecards and Kits,Custom Hiring Pipelines,Vendor Management,Autopilot (Recruiting Automations),Interview Scheduling with Google & Outlook Calendar,Manage unlimited employee documents,Job board Integrations,Time Off Approval Workflows,Upto 2 Holiday Calendars,Upto 2 Time Off Policies,Upto 2 work-week configurations,Phone Email & Chat Support,HR Reports and Analytics,GDPR Anonymization and Automation";
//        String pro = "Upto 100 published jobs,Unlimited employees,Social Recruiting,Talent Pool Management,Job Requisition Management,Offer Management,Candidate Self-Schedule,Additional user roles with custom restrictions,Multiple recruiters for a single job posting,Custom job fields,Integration with E-Sign software,Sponsored Job Postings on Indeed,Candidate Sourcing Extension,Merge Duplicate Candidates,Multiple Language Support,New Hire Onboarding,Multiple Onboarding and Offboarding Checklists,Pre-Onboarding Data Collection & Welcome Kit,Multiple Office locations in HRIS,Unlimited Webhook Requests,Unlimited Holiday Calendars,Unlimited Time Off Policies,Unlimited work-week configurations";
//        generateFeatureTableSqlQuery();
        generatePlanFeatureMappingSqlQuery();
    }

    private static void generatePlanFeatureMappingSqlQuery() {

        AtomicInteger id = new AtomicInteger(35530);
        StringBuilder output = new StringBuilder("INSERT INTO `plan_feature_mapping` (`id`, `plan_id`, `feature_id`, `description`, `gateway_config_id`)\n" +
                "VALUES\n");
//        String plans = "free_annual_aud,free_annual_eur,free_annual_gbp,free_annual_inr,free_annual_usd";
//        String plans = "growth_annual_aud,growth_annual_eur,growth_annual_gbp,growth_annual_inr,growth_annual_usd,growth_monthly_aud,growth_monthly_eur,growth_monthly_gbp,growth_monthly_inr,growth_monthly_usd,growth_quarterly_aud,growth_quarterly_eur,growth_quarterly_gbp,growth_quarterly_inr,growth_quarterly_usd,growth_semi_annual_aud,growth_semi_annual_eur,growth_semi_annual_gbp,growth_semi_annual_inr,growth_semi_annual_usd";
//        String plans = "pro_annual_aud,pro_annual_eur,pro_annual_gbp,pro_annual_inr,pro_annual_usd,pro_monthly_aud,pro_monthly_eur,pro_monthly_gbp,pro_monthly_inr,pro_monthly_usd,pro_quarterly_aud,pro_quarterly_eur,pro_quarterly_gbp,pro_quarterly_inr,pro_quarterly_usd,pro_semi_annual_aud,pro_semi_annual_eur,pro_semi_annual_gbp,pro_semi_annual_inr,pro_semi_annual_usd";
        String plans = "enterprise_annual_aud,enterprise_annual_eur,enterprise_annual_gbp,enterprise_annual_inr,enterprise_annual_usd,enterprise_monthly_aud,enterprise_monthly_eur,enterprise_monthly_gbp,enterprise_monthly_inr,enterprise_monthly_usd,enterprise_quarterly_aud,enterprise_quarterly_eur,enterprise_quarterly_gbp,enterprise_quarterly_inr,enterprise_quarterly_usd,enterprise_semi_annual_aud,enterprise_semi_annual_eur,enterprise_semi_annual_gbp,enterprise_semi_annual_inr,enterprise_semi_annual_usd";

        for (String plan : plans.split(",")) {
            for (int i=502; i <=509; i++) { //Free
//            for (int i=460; i <=476; i++) { //Growth
//            for (int i=476; i <=504; i++) { //Pro
//            for (int i=475; i <=504; i++) { //enterprise
                String template = "({id}, '{plan}', {i}, '', 479492512410239036),\n";
                template = template.replace("{id}", String.valueOf(id.incrementAndGet()));
                template = template.replace("{plan}", plan);
                template = template.replace("{i}", String.valueOf(i));
                output.append(template);
            }
        }
        System.out.println(output);
    }

    private static void generateFeatureTableSqlQuery() {
//        String feature = "Upto 3 published jobs,Upto 50 employees,Recruitment Team inbox,Basic Career Site,Email Integration,Kanban Boards for applicant tracking,Team Collaboration,Candidate Application via Email,Employee Referral,Employee Directory,Organization chart,Mobile apps (iOS and Android),Basic Time Off Management,Payroll Management";
//        String feature = "Upto 20 published jobs,Unlimited employees,Customizable Career Site,Customizable applicant form,Custom Interview Scorecards and Kits,Custom Hiring Pipelines,Vendor Management,Autopilot (Recruiting Automations),Interview Scheduling with Google & Outlook Calendar,Manage unlimited employee documents,Job board Integrations,Time Off Approval Workflows,Upto 2 Holiday Calendars,Upto 2 Time Off Policies,Upto 2 work-week configurations,Phone Email & Chat Support,HR Reports and Analytics,GDPR Anonymization and Automation";
//        String feature = "Upto 100 published jobs,Unlimited employees,Advanced Career Site Customizations,Social Recruiting,Talent Pool Management,Job Requisition Management,Offer Management,Candidate Self-Schedule,Additional user roles with custom restrictions,Multiple recruiters for a single job posting,Custom job fields,Integration with E-Sign software,Sponsored Job Postings on Indeed,Candidate Sourcing Extension,Merge Duplicate Candidates,Multiple Language Support,New Hire Onboarding,Multiple Onboarding and Offboarding Checklists,Pre-Onboarding Data Collection & Welcome Kit,Multiple Office locations in HRIS,Unlimited Webhook Requests,Unlimited Holiday Calendars,Unlimited Time Off Policies,Unlimited work-week configurations";
        String feature = "Unlimited jobs,Unlimited employees,Custom User Roles,Access Restrictions based on IP Address,Custom URL & SSL Certificate,One click data export,Sensitive privilege workflow,Dedicated Account Manager";

        AtomicInteger temp = new AtomicInteger(501);
        AtomicInteger temp2 = new AtomicInteger(268);

        StringBuilder output = new StringBuilder("INSERT INTO `feature` (`id`, `name`, `display_name`, `external_id`, `group_name`, `created_at`, `updated_at`, `ui_display_flag`)\n" +
                "VALUES\n");
        for (String val : feature.split(",")) {
            String template = "({temp1}, '{id}', '{name}', '{temp2}', '', '{NULL}', '{NULL}', 1),\n";

            String tempVal = val;
            template = template.replace("{temp1}", String.valueOf(temp.incrementAndGet()));
            template = template.replace("{id}", "ft_" + tempVal.toLowerCase().replace(" ", "_"));
            template = template.replace("{name}", val);
            template = template.replace("{name}", val);
            template = template.replace("{NULL}", Instant.now().toString());
            template = template.replace("{temp2}", String.valueOf(temp2.incrementAndGet()));

            output.append(template);
        }

        System.out.println(output);
    }
}

//
