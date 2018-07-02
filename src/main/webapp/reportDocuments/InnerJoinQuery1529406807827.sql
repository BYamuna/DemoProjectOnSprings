select t.id,t.assignto,u.username,t.category,s.servicetypename,t.created_time,t.description,t.kstatus,ts.name as statusname,t.priority as priorityid,p.priority,t.severity as severityid,sev.severity,
t.status,t.subject,t.taskdeadline,t.taskno
FROM abhee_task t,abheeusers u,abheeservicetype s,abheetaskstatus ts,abheepriority p,abheeseverity sev
where t.assignto=u.id and t.category=s.id and t.kstatus=ts.id and t.priority=p.id and t.severity=sev.id;