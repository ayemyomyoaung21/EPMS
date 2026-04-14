import { useState } from "react";
import { Eye, EyeOff } from "lucide-react";

const HomePage = () => {
  const [showLogin, setShowLogin] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  return (
    <div className="min-h-screen bg-[#cfe3ec]">
      {/* HEADER */}
      <header className="bg-[#044f76] text-white flex justify-between items-center px-6 py-3">
        <div className="text-xl font-bold">LOGO</div>

        <button
          onClick={() => setShowLogin(true)}
          className="bg-white text-[#044f76] px-4 py-2 rounded-lg font-semibold"
        >
          Login
        </button>
      </header>

      {/* BODY */}
      <div className="flex h-[calc(100vh-60px)]">
        {/* LEFT IMAGE */}
        <div className="w-1/2">
          <img
            src="/image.png"
            alt="home"
            className="w-full h-full object-cover"
          />
        </div>

        {/* RIGHT SECTION */}
        <div className="w-1/2 flex items-center justify-center p-10">
          {!showLogin ? (
            /* INFO DIV */
            <div className="text-[#044f76] text-lg font-semibold">
              Information Section
            </div>
          ) : (
            /* LOGIN FORM */
            <div className="bg-white p-8 rounded-2xl shadow-md w-[320px]">
              <div className="mb-4">
                <input
                  type="text"
                  className="w-full border rounded-lg px-3 py-2 outline-none"
                />
              </div>

              {/* PASSWORD FIELD */}
              <div className="relative mb-6">
                <input
                  type={showPassword ? "text" : "password"}
                  className="w-full border rounded-lg px-3 py-2 pr-10 outline-none"
                />

                {/* SINGLE TOGGLE ICON (FIXED) */}
                <span
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute right-3 top-1/2 -translate-y-1/2 cursor-pointer"
                >
                  {showPassword ? <EyeOff size={18} /> : <Eye size={18} />}
                </span>
              </div>

              {/* BUTTONS */}
              <div className="flex justify-between">
                <button className="bg-[#044f76] text-white px-4 py-2 rounded-lg">
                  Login
                </button>

                <button
                  onClick={() => setShowLogin(false)}
                  className="border px-4 py-2 rounded-lg"
                >
                  Cancel
                </button>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default HomePage;