import { Users, TrendingUp, Calendar, Clock, CheckCircle, AlertCircle } from 'lucide-react';

const Dashboard = () => {
  const stats = [
    { title: 'Total Employees', value: '245', change: '+55% than last week', icon: Users, color: '#044f76' },
    { title: 'Active Employees', value: '1081', change: '+12% than last week', icon: TrendingUp, color: '#10b981' },
    { title: 'Total Tasks', value: '34', change: '+8% than last week', icon: CheckCircle, color: '#f59e0b' },
    { title: 'Just Updated', value: '+91', change: 'New updates', icon: AlertCircle, color: '#ef4444' },
  ];
  
  const departments = [
    { name: 'Accounting and Finance', employees: 245, updated: '2 days ago' },
    { name: 'Human Resources', employees: 245, updated: '2 days ago' },
    { name: 'Engineering and Development', employees: 245, updated: '2 days ago' },
    { name: 'Sales and Marketing', employees: 245, updated: '3 days ago' },
  ];
  
  const recentActivities = [
    { dept: 'Engineering and Development', employees: 245, updated: '2 days ago' },
    { dept: 'Engineering and Development', employees: 245, updated: '3 days ago' },
    { dept: 'Engineering and Development', employees: 245, updated: '2 days ago' },
  ];
  
  return (
    <div>
      {/* Page Title */}
      <div className="mb-6">
        <h1 className="text-2xl font-bold" style={{ color: '#044f76' }}>Dashboard</h1>
        <p className="text-gray-500">Welcome back, {localStorage.getItem('staffName') || 'Administrator'}</p>
      </div>
      
      {/* Stats Cards */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
        {stats.map((stat) => (
          <div key={stat.title} className="bg-white rounded-xl shadow-sm p-6">
            <div className="flex items-center justify-between mb-4">
              <div className="w-12 h-12 rounded-lg flex items-center justify-center" style={{ backgroundColor: stat.color + '20' }}>
                <stat.icon className="w-6 h-6" style={{ color: stat.color }} />
              </div>
              <span className="text-green-600 text-sm font-medium">{stat.change}</span>
            </div>
            <h3 className="text-2xl font-bold text-gray-800">{stat.value}</h3>
            <p className="text-gray-500 text-sm mt-1">{stat.title}</p>
          </div>
        ))}
      </div>
      
      {/* Two Column Layout */}
      <div className="grid lg:grid-cols-3 gap-6">
        {/* Left Column - Departments */}
        <div className="lg:col-span-2 space-y-6">
          <div className="bg-white rounded-xl shadow-sm">
            <div className="p-6 border-b">
              <h2 className="text-lg font-semibold" style={{ color: '#044f76' }}>Department Overview</h2>
            </div>
            <div className="divide-y">
              {departments.map((dept) => (
                <div key={dept.name} className="p-6 flex items-center justify-between">
                  <div>
                    <h3 className="font-medium text-gray-800">{dept.name}</h3>
                    <p className="text-sm text-gray-500">Total Employee: {dept.employees} • Updated {dept.updated}</p>
                  </div>
                  <button className="text-sm text-blue-600 hover:text-blue-700">View Details →</button>
                </div>
              ))}
            </div>
          </div>
          
          {/* Recent Activities */}
          <div className="bg-white rounded-xl shadow-sm">
            <div className="p-6 border-b">
              <h2 className="text-lg font-semibold" style={{ color: '#044f76' }}>Recent Activities</h2>
            </div>
            <div className="divide-y">
              {recentActivities.map((activity, idx) => (
                <div key={idx} className="p-6">
                  <h3 className="font-medium text-gray-800">{activity.dept}</h3>
                  <p className="text-sm text-gray-500">Total Employee: {activity.employees} • Updated {activity.updated}</p>
                </div>
              ))}
            </div>
          </div>
        </div>
        
        {/* Right Column - Attendance */}
        <div className="space-y-6">
          <div className="bg-white rounded-xl shadow-sm">
            <div className="p-6 border-b">
              <h2 className="text-lg font-semibold" style={{ color: '#044f76' }}>Today's Attendance</h2>
            </div>
            <div className="p-6">
              <div className="text-center mb-6">
                <div className="text-4xl font-bold text-gray-800">08</div>
                <p className="text-gray-500">Dec 2022</p>
              </div>
              <div className="space-y-4">
                <div className="flex justify-between">
                  <span className="text-gray-600">Check-in</span>
                  <span className="font-medium">09:36</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Check-out</span>
                  <span className="font-medium">18:55</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Work Time</span>
                  <span className="font-medium">8hr 02min</span>
                </div>
                <div className="flex justify-between">
                  <span className="text-gray-600">Break Time</span>
                  <span className="font-medium">45min</span>
                </div>
                <div className="flex justify-between pt-4 border-t">
                  <span className="text-gray-600">Extra Hours</span>
                  <span className="font-medium text-green-600">+2.5hrs</span>
                </div>
              </div>
            </div>
          </div>
          
          {/* Quick Stats */}
          <div className="bg-gradient-to-r rounded-xl shadow-sm p-6 text-white" style={{ background: 'linear-gradient(135deg, #044f76 0%, #0369a1 100%)' }}>
            <h3 className="font-semibold mb-2">Performance Summary</h3>
            <p className="text-3xl font-bold mb-1">92%</p>
            <p className="text-white/80 text-sm">Overall completion rate</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;